package com.astrobookings.fleets.domain.models;

public record CreateRocketCommand(String name, int capacity, Double maxSpeed) {
}
