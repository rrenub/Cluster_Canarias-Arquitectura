package com.astrobookings.sales.domain.ports.output;

import com.astrobookings.fleets.domain.models.Rocket;
import com.astrobookings.sales.domain.models.RocketInfo;

public interface RocketsProvider {
    RocketInfo findById(String id);
} 
