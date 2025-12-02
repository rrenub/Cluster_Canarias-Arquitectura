package com.astrobookings.config;

import com.astrobookings.business.RocketService;
import com.astrobookings.business.interfaces.RocketServiceContract;
import com.astrobookings.persistence.InMemoryRocketRepository;
import com.astrobookings.persistence.interfaces.RocketRepository;

public class AppFactory {

    public AppFactory(){}
    
    public RocketServiceContract createRocketService() {
        RocketRepository rocketRepository = new InMemoryRocketRepository();
        return new RocketService(rocketRepository);
    }
}
