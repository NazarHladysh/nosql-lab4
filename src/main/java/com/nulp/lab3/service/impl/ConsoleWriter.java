package com.nulp.lab3.service.impl;

import com.nulp.lab3.model.Trip;
import com.nulp.lab3.service.Strategy;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ConsoleWriter implements Strategy {
    @Override
    public void execute(List<Trip> trips) {
        trips.forEach(System.out::println);
    }
}
