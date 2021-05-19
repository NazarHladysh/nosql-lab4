package com.nulp.lab3.repository;

import com.nulp.lab3.model.Trip;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface TripRepository extends CassandraRepository<Trip, Long> {
}
