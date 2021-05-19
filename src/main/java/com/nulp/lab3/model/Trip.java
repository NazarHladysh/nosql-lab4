package com.nulp.lab3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table
public class Trip {
    @JsonProperty("trip_id")
    @PrimaryKey
    private Long tripId;
    private Double duration;
    @JsonProperty("start_time")
    private LocalDateTime startTime;
    @JsonProperty("end_time")
    private LocalDateTime endTime;
    @JsonProperty("starting_station_id")
    private Long startingStationId;
    @JsonProperty("starting_station_latitude")
    private Double startingStationLatitude;
    @JsonProperty("starting_station_longitude")
    private Double startingStationLongitude;
    @JsonProperty("ending_station_id")
    private Long endingStationId;
    @JsonProperty("ending_station_latitude")
    private Double endingStationLatitude;
    @JsonProperty("ending_station_longitude")
    private Double endingStationLongitude;
    @JsonProperty("bike_id")
    private Long bikeId;
    @JsonProperty("plan_duration")
    private Double planDuration;
    @JsonProperty("trip_route_category")
    private String tripRouteCategory;
    @JsonProperty("passholder_type")
    private String passholderType;
    @JsonProperty("starting_lat_long")
    @Transient
    private Location startingLatLong;
    @JsonProperty("ending_lat_long")
    @Transient
    private Location endingLatLong;

}
