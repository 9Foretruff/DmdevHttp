package com.foretruff.http.dto;

import java.util.Objects;

public class TicketDto {
    private final Long id;
    private final Long flightId;
    private final String seatNo;

    public TicketDto(Long id, Long flightId, String seatNo) {
        this.id = id;
        this.flightId = flightId;
        this.seatNo = seatNo;
    }

    public Long getId() {
        return id;
    }

    public Long getFlightId() {
        return flightId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketDto ticketDto = (TicketDto) o;

        if (!Objects.equals(id, ticketDto.id)) return false;
        if (!Objects.equals(flightId, ticketDto.flightId)) return false;
        return Objects.equals(seatNo, ticketDto.seatNo);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (flightId != null ? flightId.hashCode() : 0);
        result = 31 * result + (seatNo != null ? seatNo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
               "id=" + id +
               ", flightId=" + flightId +
               ", seatNo='" + seatNo + '\'' +
               '}';
    }
}
