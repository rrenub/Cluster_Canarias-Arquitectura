package com.astrobookings.fleets.infrastructure.persistence;

import com.astrobookings.fleets.domain.ports.output.RocketRepository;

public class FleetPersistenceAdapterFactory {
    private static final RocketRepository rocketRepository = new RocketInMemoryRepository();

    public static RocketRepository getRocketRepository() {
        return rocketRepository;
    }
}
