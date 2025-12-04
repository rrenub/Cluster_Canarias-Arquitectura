package com.astrobookings.fleets.domain.models;

public class RocketCapacity {
    private final int capacity;

    public RocketCapacity(int capacity) {
        if(capacity <= 0 || capacity > 10) {
            throw new IllegalArgumentException("Capacity cannot be 0 or greater than 10");
        }
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
