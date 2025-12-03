package com.astrobookings.sales.domain.ports.output;

import com.astrobookings.fleets.domain.models.Rocket;

public interface RocketsProvider {
    Rocket findById(String id);
} 
