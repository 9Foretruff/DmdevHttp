package com.foretruff.http.mapper;

import com.foretruff.http.dto.CreateUserDto;
import com.foretruff.http.entity.GenderEnum;
import com.foretruff.http.entity.RoleEnum;
import com.foretruff.http.entity.UserEntity;
import com.foretruff.http.util.LocalDateFormatter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.*;

@NoArgsConstructor(access = PRIVATE)
public class CreateUserMapper implements Mapper<CreateUserDto, UserEntity> {
    public static final String IMAGE_FOLDER = "users/";
    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public UserEntity mapFrom(CreateUserDto object) {
        return UserEntity.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .image(IMAGE_FOLDER + object.getImage().getSubmittedFileName())
                .gender(GenderEnum.valueOf(object.getGender()))
                .role(RoleEnum.valueOf(object.getRole()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }

}
