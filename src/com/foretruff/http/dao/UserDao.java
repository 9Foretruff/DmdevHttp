package com.foretruff.http.dao;

import com.foretruff.http.entity.GenderEnum;
import com.foretruff.http.entity.RoleEnum;
import com.foretruff.http.entity.UserEntity;
import com.foretruff.http.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Long, UserEntity> {
    private static final UserDao INSTANCE = new UserDao();
    public static final String SAVE_SQL = """
            INSERT INTO users(name, birthday, email, image, password, role, gender)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;
    public static final String GET_BY_EMAIL_AND_PASSWORD_SQL = """
                  SELECT id, name, birthday, email, image, password, role, gender
                  FROM users
                  WHERE email = ? AND password = ?
            """;


    private UserDao() {
    }

    @SneakyThrows
    public Optional<UserEntity> findByEmailAndPassword(String email, String password) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(GET_BY_EMAIL_AND_PASSWORD_SQL)) {
            preparedStatement.setObject(1, email);
            preparedStatement.setObject(2, password);

            var resultSet = preparedStatement.executeQuery();
            UserEntity user = null;
            if (resultSet.next()) {
                user = buildUser(resultSet);
            }
            return Optional.ofNullable(user);
        }
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(UserEntity entity) {

    }

    @SneakyThrows
    @Override
    public UserEntity save(UserEntity entity) {
        try (var connection = ConnectionManager.get();
             var saveStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            saveStatement.setObject(1, entity.getName());
            saveStatement.setObject(2, entity.getBirthday());
            saveStatement.setObject(3, entity.getEmail());
            saveStatement.setObject(4, entity.getImage());
            saveStatement.setObject(5, entity.getPassword());
            saveStatement.setObject(6, entity.getRole().name());
            saveStatement.setObject(7, entity.getGender().name());

            saveStatement.executeUpdate();

            var generatedKeys = saveStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getLong("id"));

            return entity;
        }
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }

    @SneakyThrows
    private UserEntity buildUser(ResultSet resultSet) {
        return UserEntity.builder()
                .id(resultSet.getObject("id", Long.class))
                .name(resultSet.getObject("name", String.class))
                .birthday(resultSet.getObject("birthday", Date.class).toLocalDate())
                .email(resultSet.getObject("email", String.class))
                .image(resultSet.getObject("image", String.class))
                .password(resultSet.getObject("password", String.class))
                .role(RoleEnum.find(resultSet.getObject("role", String.class)).orElse(null))
                .gender(GenderEnum.valueOf(resultSet.getObject("gender", String.class)))
                .build();
    }
}
