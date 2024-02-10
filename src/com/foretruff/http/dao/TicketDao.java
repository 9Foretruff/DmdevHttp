package com.foretruff.http.dao;

import com.foretruff.http.entity.TicketEntity;
import com.foretruff.http.util.ConnectionManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long, TicketEntity> {
    private static final TicketDao INSTANCE = new TicketDao();
    private static final String FIND_ALL_BY_FLIGHT_ID_SQL = """
                SELECT
                id,
                passenger_no,
                passenger_name,
                flight_id,
                seat_no,
                cost
                FROM ticket
                WHERE flight_id = ?
            """;

    private TicketDao() {
    }

    public List<TicketEntity> findAllByFlightId(Long flightId) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_BY_FLIGHT_ID_SQL)) {
            preparedStatement.setLong(1, flightId);

            var resultSet = preparedStatement.executeQuery();
            List<TicketEntity> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(buildTicket(resultSet));
            }

            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TicketEntity> findAll() {
        return null;
    }

    @Override
    public Optional<TicketEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(TicketEntity entity) {

    }

    @Override
    public TicketEntity save(TicketEntity entity) {
        return null;
    }

    public static TicketDao getInstance() {
        return INSTANCE;
    }

    private TicketEntity buildTicket(ResultSet resultSet) throws SQLException {
        return new TicketEntity(
            resultSet.getObject("id", Long.class),
            resultSet.getObject("passenger_no", String.class),
            resultSet.getObject("passenger_name", String.class),
            resultSet.getObject("flight_id", Long.class),
            resultSet.getObject("seat_no", String.class),
            resultSet.getObject("cost", BigDecimal.class)
        );

    }
}
