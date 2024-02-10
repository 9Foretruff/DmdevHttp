package com.foretruff.http.service;

import com.foretruff.http.dao.FlightDao;
import com.foretruff.http.dto.FlightDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightService {
    private static final FlightService INSTANCE = new FlightService();
    private final FlightDao flightDao = FlightDao.getInstance();

    private FlightService() {
    }

    public List<FlightDto> findAll() {
        return flightDao.findAll().stream()
                .map(flightEntity -> new FlightDto(
                        flightEntity.getId(),
                        """
                                 %s - %s - %s
                                """.formatted(flightEntity.getDepartureAirportCode(), flightEntity.getArrivalAirportCode(), flightEntity.getStatus())
                ))
                .collect(toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}
