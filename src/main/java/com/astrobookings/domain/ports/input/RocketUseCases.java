package com.astrobookings.domain.ports.input;

import java.util.List;

import com.astrobookings.domain.models.Rocket;
import com.astrobookings.domain.models.RocketDto;

public interface RocketUseCases {
    public List<Rocket> getRockets();
    public RocketDto save(RocketDto rocketDto);
}
