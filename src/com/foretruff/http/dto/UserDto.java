package com.foretruff.http.dto;

import com.foretruff.http.entity.GenderEnum;
import com.foretruff.http.entity.RoleEnum;
import jakarta.servlet.http.Part;
import lombok.Builder;
import lombok.Value;

import java.io.InputStream;
import java.time.LocalDate;

@Value
@Builder
public class UserDto {
    Long id;
    String name;
    LocalDate birthday;
    String email;
    String image;
    RoleEnum role;
    GenderEnum gender;
}
