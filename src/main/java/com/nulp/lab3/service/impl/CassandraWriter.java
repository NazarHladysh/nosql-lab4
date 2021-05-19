package com.nulp.lab3.service.impl;

import com.nulp.lab3.model.Trip;
import com.nulp.lab3.repository.TripRepository;
import com.nulp.lab3.service.Strategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class CassandraWriter implements Strategy {
    private final TripRepository tripRepository;

    @Override
    public void execute(List<Trip> trips) {
        tripRepository.saveAll(trips);
    }
}
