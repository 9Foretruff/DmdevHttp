package com.foretruff.http.entity;

import lombok.*;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private Long id;
    private String name;
    private LocalDate birthday;
    private String email;
    private String image;
    private String password;
    private RoleEnum role;
    private GenderEnum gender;
}
