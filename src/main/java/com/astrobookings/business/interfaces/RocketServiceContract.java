package com.astrobookings.business.interfaces;

import java.util.List;

import com.astrobookings.business.models.RocketDto;
import com.astrobookings.persistence.models.Rocket;

public interface IRocketService {
    public List<Rocket> getRockets();
    public RocketDto save(RocketDto rocketDto);
}
