package com.foretruff.http.dto;

import lombok.Builder;
import lombok.Value;

import java.util.Objects;

@Value
@Builder
public class TicketDto {
    Long id;
    Long flightId;
    String seatNo;
}
