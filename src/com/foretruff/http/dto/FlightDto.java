package com.foretruff.http.dto;

import lombok.*;

import java.util.Objects;

//@AllArgsConstructor
//@Getter
//@EqualsAndHashCode
//@ToString
//@Data
//@Builder
@Value
@Builder
public class FlightDto {
    Long id;
    String description;
}