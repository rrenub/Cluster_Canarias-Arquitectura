package com.astrobookings.domain.ports;

import java.util.List;

import com.astrobookings.infrastructure.models.Rocket;

public interface RocketRepository {
    public List<Rocket> findAll();
    public Rocket save(Rocket rocket);
}
