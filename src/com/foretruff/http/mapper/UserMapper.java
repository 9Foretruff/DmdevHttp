package com.foretruff.http.mapper;

import com.foretruff.http.dto.UserDto;
import com.foretruff.http.entity.UserEntity;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserMapper implements Mapper<UserEntity, UserDto> {
    private static final UserMapper INSTANCE = new UserMapper();

    @Override

    public UserDto mapFrom(UserEntity object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .image(object.getImage())
                .birthday(object.getBirthday())
                .email(object.getEmail())
                .role(object.getRole())
                .gender(object.getGender())
                .build();
    }

    public static UserMapper getInstance() {
        return INSTANCE;
    }
}
