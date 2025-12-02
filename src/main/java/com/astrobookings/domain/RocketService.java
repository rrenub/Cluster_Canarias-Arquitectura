package com.astrobookings.domain;

import java.util.List;

import com.astrobookings.domain.models.RocketDto;
import com.astrobookings.domain.ports.RocketRepository;
import com.astrobookings.domain.ports.RocketServiceContract;
import com.astrobookings.infrastructure.models.Rocket;

public class RocketService implements RocketServiceContract {
    private final RocketRepository rocketRepository;

    public RocketService(RocketRepository rocketRepository) {
        this.rocketRepository = rocketRepository;
    }

  public List<Rocket> getRockets() {
    return rocketRepository.findAll();
  }

  public RocketDto save(RocketDto rocketDto) {

    Rocket rocket = new Rocket();
    rocket.setId(rocketDto.getId());
    rocket.setName(rocketDto.getName());
    rocket.setCapacity(rocketDto.getCapacity());
    rocket.setSpeed(rocketDto.getSpeed());

    Rocket createdRocket = rocketRepository.save(rocket);

    RocketDto createdRocketDto = new RocketDto();
    createdRocketDto.setId(createdRocket.getId());
    createdRocketDto.setName(createdRocket.getName());
    createdRocketDto.setCapacity(createdRocket.getCapacity());
    createdRocketDto.setSpeed(createdRocket.getSpeed());

    return createdRocketDto;
  }
}
