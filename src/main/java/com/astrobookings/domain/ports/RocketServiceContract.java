package com.astrobookings.domain.ports;

import java.util.List;

import com.astrobookings.domain.models.Rocket;
import com.astrobookings.domain.models.RocketDto;

public interface RocketServiceContract {
    public List<Rocket> getRockets();
    public RocketDto save(RocketDto rocketDto);
}
