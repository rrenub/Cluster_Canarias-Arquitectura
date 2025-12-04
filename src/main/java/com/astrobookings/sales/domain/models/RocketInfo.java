package com.astrobookings.sales.domain.models;

public class RocketInfo {
    private String id;
    private int capacity;

    public RocketInfo(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getId() {
        return this.id;
    }
}
