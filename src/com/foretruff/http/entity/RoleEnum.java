package com.foretruff.http.entity;

import java.util.Arrays;
import java.util.Optional;

public enum RoleEnum {
    USER,
    ADMIN;

    public static Optional<RoleEnum> find(String role) {
        return Arrays.stream(values())
                .filter(it -> it.name().equals(role))
                .findFirst();
    }
}
