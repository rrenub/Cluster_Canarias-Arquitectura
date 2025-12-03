package com.astrobookings.sales.infrastructure.persistence;

import com.astrobookings.fleets.domain.models.Rocket;
import com.astrobookings.fleets.domain.ports.output.RocketRepository;
import com.astrobookings.sales.domain.ports.output.RocketsProvider;

public class RocketsAdapter implements RocketsProvider {

    private final RocketRepository rocketRepository;

    public RocketsAdapter(RocketRepository rocketRepository) {
        this.rocketRepository = rocketRepository;
    }

    @Override
    public Rocket findById(String id) {
        return rocketRepository.findById(id);
    }
    
}
