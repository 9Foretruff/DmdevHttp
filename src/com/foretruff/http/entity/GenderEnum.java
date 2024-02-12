package com.foretruff.http.entity;

import java.util.Arrays;
import java.util.Optional;

public enum GenderEnum {
    MALE,
    FEMALE;

    public static Optional<GenderEnum> find(String gender) {
        return Arrays.stream(values())
                .filter(it -> it.name().equals(gender))
                .findFirst();
    }
}
