package com.astrobookings.fleets.domain.ports.output;

import java.util.List;

import com.astrobookings.fleets.domain.models.Rocket;

public interface RocketRepository {
  List<Rocket> findAll();

  Rocket findById(String id);

  Rocket save(Rocket rocket);
}
