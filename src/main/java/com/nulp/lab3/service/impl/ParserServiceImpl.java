package com.nulp.lab3.service.impl;

import com.nulp.lab3.model.Trip;
import com.nulp.lab3.service.ParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParserServiceImpl implements ParserService {

    private final RestTemplate restTemplate;

    @Override
    public List<Trip> parseTrips(String url) {
        Trip[] trips = restTemplate.getForObject(url, Trip[].class);
        return Arrays.asList(trips);
    }
}
