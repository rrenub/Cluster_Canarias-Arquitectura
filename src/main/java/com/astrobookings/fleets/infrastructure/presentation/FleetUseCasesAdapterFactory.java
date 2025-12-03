package com.astrobookings.fleets.infrastructure.presentation;

import com.astrobookings.fleets.domain.RocketsService;
import com.astrobookings.fleets.domain.ports.input.RocketsUseCases;
import com.astrobookings.fleets.domain.ports.output.RocketRepository;

public class FleetUseCasesAdapterFactory {
    public static RocketsUseCases getRocketsUseCase(RocketRepository rocketRepository) {
        return new RocketsService(rocketRepository);
    }
}
