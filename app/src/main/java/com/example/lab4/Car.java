package com.example.lab4;

public class Car extends Vehicle implements CombustionVehicle, Parkable{
    // Fuel mapping (bitmask):
    // 1 = DIESEL
    // 2 = PETROL
    // 4 = LPG
    // 8 = CNG

    public static final int DIESEL = 1 << 0;
    public static final int PETROL = 1 << 1;
    public static final int LPG    = 1 << 2;
    public static final int CNG    = 1 << 3;

    private int supportedFuelMask;
    private double fuelAmount;
    private Garage garage;

    public Car(String name, int fuelMask) {
        super(name);
        this.supportedFuelMask = fuelMask;
        this.fuelAmount = 0;
    }

    @Override
    public boolean refuel(int fuelMask, double liters) {
        if (liters <= 0) return false;

        if ((supportedFuelMask & fuelMask) != 0) {
            fuelAmount += liters;
            return true;
        }
        return false;
    }

    @Override
    public int getSupportedFuelMask() {
        return supportedFuelMask;
    }

    @Override
    public double getFuelAmount() {
        return fuelAmount;
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

        return "[" + getId() + "] Car: " + getName() +
                " | FuelType=" + supportedFuelMask +
                " | FuelAmount=" + fuelAmount +
                " | Parked=" + (isParked() ? "Yes" : "No") +
                " | Garage=" + garageInfo;
    }
}
