package com.astrobookings.domain.ports.output;

import java.util.List;

import com.astrobookings.domain.models.Rocket;

public interface RocketRepository {
    public List<Rocket> findAll();
    public Rocket save(Rocket rocket);
}
