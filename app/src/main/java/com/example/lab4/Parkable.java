package com.example.lab4;

public interface Parkable {
    boolean park(Garage garage);

    boolean unpark();

    boolean isParked();

    Garage getGarage();
}
