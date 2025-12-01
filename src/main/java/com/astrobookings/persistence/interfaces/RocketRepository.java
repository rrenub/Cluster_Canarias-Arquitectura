package com.astrobookings.persistence.interfaces;

import java.util.List;

import com.astrobookings.persistence.models.Rocket;

public interface RocketRepository {
    public List<Rocket> findAll();
    public Rocket save(Rocket rocket);
}
