package com.astrobookings.config;

import com.astrobookings.domain.RocketService;
import com.astrobookings.domain.ports.RocketRepository;
import com.astrobookings.domain.ports.RocketServiceContract;
import com.astrobookings.infrastructure.InMemoryRocketRepository;

public class AppFactory {

    public AppFactory(){}
    
    public RocketServiceContract createRocketService() {
        RocketRepository rocketRepository = new InMemoryRocketRepository();
        return new RocketService(rocketRepository);
    }
}
