package com.astrobookings.business;

import java.util.List;

import com.astrobookings.business.interfaces.IRocketService;
import com.astrobookings.business.models.RocketDto;
import com.astrobookings.persistence.interfaces.RocketRepository;
import com.astrobookings.persistence.models.Rocket;

public class RocketService implements IRocketService {
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
