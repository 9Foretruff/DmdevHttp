package com.foretruff.http.service;

import com.foretruff.http.dao.TicketDao;
import com.foretruff.http.dto.TicketDto;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class TicketService {
    private static final TicketService INSTANCE = new TicketService();
    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService() {
    }

    public List<TicketDto> findAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId)
                .stream()
                .map(ticketEntity -> TicketDto.builder()
                        .id(ticketEntity.getId())
                        .flightId(ticketEntity.getFlightId())
                        .seatNo(ticketEntity.getSeatNo())
                        .build())
                .collect(toList());
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }
}
