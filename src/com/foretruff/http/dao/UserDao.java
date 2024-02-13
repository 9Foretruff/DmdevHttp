package com.foretruff.http.dao;

import com.foretruff.http.entity.RoleEnum;
import com.foretruff.http.entity.UserEntity;
import com.foretruff.http.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Long, UserEntity> {
    private static final UserDao INSTANCE = new UserDao();
    public static final String SAVE_SQL = """
            INSERT INTO users(name, birthday, email, image, password, role, gender)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

    private UserDao() {
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
}
