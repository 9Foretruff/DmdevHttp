package com.foretruff.http.service;


import com.foretruff.http.dao.UserDao;
import com.foretruff.http.dto.CreateUserDto;
import com.foretruff.http.dto.UserDto;
import com.foretruff.http.entity.UserEntity;
import com.foretruff.http.exception.ValidationException;
import com.foretruff.http.mapper.CreateUserMapper;
import com.foretruff.http.mapper.UserMapper;
import com.foretruff.http.validator.CreateUserValidator;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    public final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    public final UserMapper userMapper = UserMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();

    @SneakyThrows
    public Long save(CreateUserDto userDto) {
        // validation
        // map
        // userDao.save
        // return id
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
        imageService.upload(userEntity.getImage(), userDto.getImage().getInputStream());
        var save = userDao.save(userEntity);

        return save.getId();
    }

    public Optional<UserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email, password)
                .map(userMapper::mapFrom);
    }

    public static UserService getInstance() {
        return INSTANCE;
    }

}
