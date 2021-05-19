package com.nulp.lab3.service;

import com.nulp.lab3.model.Trip;

import java.util.List;

public interface Strategy {
    void execute(List<Trip> trips);
}
