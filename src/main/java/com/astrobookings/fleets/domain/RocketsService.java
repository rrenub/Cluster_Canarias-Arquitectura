package com.astrobookings.fleets.domain;

import java.util.List;

import com.astrobookings.fleets.domain.models.CreateRocketCommand;
import com.astrobookings.fleets.domain.models.Rocket;
import com.astrobookings.fleets.domain.ports.input.RocketsUseCases;
import com.astrobookings.fleets.domain.ports.output.RocketRepository;
import com.astrobookings.shared.models.BusinessErrorCode;
import com.astrobookings.shared.models.BusinessException;

public class RocketsService implements RocketsUseCases {
  private final RocketRepository rocketRepository;

  public RocketsService(RocketRepository rocketRepository) {
    this.rocketRepository = rocketRepository;
  }

  public List<Rocket> getAllRockets() {
    return rocketRepository.findAll();
  }

  public Rocket saveRocket(CreateRocketCommand command) {
    validate(command);

    Rocket rocket = new Rocket();
    rocket.setName(command.name());
    rocket.setCapacity(command.capacity());
    rocket.setSpeed(command.maxSpeed());
    return rocketRepository.save(rocket);
  }

  private void validate(CreateRocketCommand command) {
    if (command.capacity() <= 0 || command.capacity() > 10) {
      throw new BusinessException(BusinessErrorCode.VALIDATION, "Rocket capacity must be between 1 and 10");
    }
  }
}
