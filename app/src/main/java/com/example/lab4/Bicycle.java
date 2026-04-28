package com.example.lab4;

public class Bicycle extends Vehicle implements Parkable{

    private Garage garage;

    public Bicycle(String name) {
        super(name);
    }

    @Override
    public boolean park(Garage garage) {
        if (this.garage != null) return false;
        if (!garage.isEmpty()) return false;

        this.garage = garage;
        garage.setParkedVehicle(this);
        return true;
    }

    @Override
    public boolean unpark() {
        if (garage == null) return false;

        garage.setParkedVehicle(null);
        garage = null;
        return true;
    }

    @Override
    public boolean isParked() {
        return garage != null;
    }

    @Override
    public Garage getGarage() {
        return garage;
    }

    @Override
    public String toString() {
        String garageInfo = isParked() ? String.valueOf(garage.getNumber()) : "-";

        return "[" + getId() + "] Bicycle: " + getName() +
                " | Parked=" + (isParked() ? "Yes" : "No") +
                " | Garage=" + garageInfo;
    }
}
