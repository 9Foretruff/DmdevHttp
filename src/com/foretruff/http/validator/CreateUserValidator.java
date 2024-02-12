package com.foretruff.http.validator;

import com.foretruff.http.dto.CreateUserDto;
import com.foretruff.http.entity.GenderEnum;
import com.foretruff.http.entity.RoleEnum;
import com.foretruff.http.util.LocalDateFormatter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CreateUserValidator implements Validator<CreateUserDto> {
    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        var validationResult = new ValidationResult();
        var name = object.getName();
        if (name == null || name.length() > 128 || name.isBlank()) {
            validationResult.add(Error.of("invalid.name", "Name is invalid"));
        }
        if (!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid.birthday", "Birthday is invalid"));
        }
        var email = object.getEmail();
        if (email == null || email.length() > 128 || email.isBlank()) {
            validationResult.add(Error.of("invalid.email", "Email is invalid"));
        }
        var password = object.getPassword();
        if (password == null || password.length() > 32 || password.isBlank()) {
            validationResult.add(Error.of("invalid.password", "Password is invalid"));
        }
        if (RoleEnum.find(object.getRole()).isEmpty()) {
            validationResult.add(Error.of("invalid.role", "Role is invalid"));
        }
        if (GenderEnum.find(object.getGender()).isEmpty()) {
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
