package com.foretruff.http.dao;

import com.foretruff.http.entity.FlightEntity;
import com.foretruff.http.entity.FlightStatus;
import com.foretruff.http.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, FlightEntity> {
    private static final FlightDao INSTANCE = new FlightDao();

    private FlightDao() {
    }

    private static final String FIND_ALL_SQL = """
            SELECT
            id,
            flight_no,
            departure_date,
            departure_airport_code,
            arrival_date,
            arrival_airport_code,
            aircraft_id,
             status
            FROM flight
            """;

    @Override
    public List<FlightEntity> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            var resultSet = preparedStatement.executeQuery();
            List<FlightEntity> flightEntities = new ArrayList<>();
            while (resultSet.next()) {
                flightEntities.add(buildFlight(resultSet));
            }
            return flightEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<FlightEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(FlightEntity entity) {

    }

    @Override
    public FlightEntity save(FlightEntity entity) {
        return null;
    }

    public static FlightDao getInstance() {
        return INSTANCE;
    }

    private FlightEntity buildFlight(ResultSet resultSet) throws SQLException {
        return new FlightEntity(
                resultSet.getLong("id"),
                resultSet.getString("flight_no"),
                resultSet.getTimestamp("departure_date").toLocalDateTime(),
                resultSet.getString("departure_airport_code"),
                resultSet.getTimestamp("arrival_date").toLocalDateTime(),
                resultSet.getString("arrival_airport_code"),
                resultSet.getInt("aircraft_id"),
                FlightStatus.valueOf(resultSet.getObject("status", String.class))
        );
    }
}
