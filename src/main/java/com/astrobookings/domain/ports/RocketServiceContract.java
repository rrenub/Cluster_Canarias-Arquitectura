package com.astrobookings.domain.ports;

import java.util.List;

import com.astrobookings.domain.models.RocketDto;
import com.astrobookings.infrastructure.models.Rocket;

public interface RocketServiceContract {
    public List<Rocket> getRockets();
    public RocketDto save(RocketDto rocketDto);
}
