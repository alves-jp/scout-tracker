package com.scout_tracker.Scout.Tracker.domain.model;

public enum PlayerStatus {

    PROFISSIONAL("Profissional"),
    SUB_21("Sub 21"),
    SUB_17("Sub 17"),
    SUB_14("Sub 14"),
    SUB_11("Sub 11");

    private final String statusName;

    PlayerStatus(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    @Override
    public String toString() {
        return statusName;
    }
}

