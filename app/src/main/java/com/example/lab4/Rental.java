package com.example.lab4;
import java.util.ArrayList;
import java.util.Collections;

public class Rental {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<Garage> garages = new ArrayList<>();

    public Rental(int garageCount) {
        for (int i = 1; i <= garageCount; i++) {
            garages.add(new Garage(i));
        }
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public Vehicle findVehicle(int id) {
        for (Vehicle v : vehicles) {
            if (v.getId() == id) return v;
        }
        return null;
    }

    public Garage findGarage(int number) {
        for (Garage g : garages) {
            if (g.getNumber() == number) return g;
        }
        return null;
    }

    public String parkVehicle(int id, int garageNumber) {
        Vehicle v = findVehicle(id);
        Garage g = findGarage(garageNumber);

        if (v == null || g == null) return "Invalid ID or garage";

        if (!(v instanceof Parkable)) {
            return "Vehicle not parkable";
        }

        Parkable p = (Parkable) v;

        if (!g.isEmpty()) {
            return "Garage occupied";
        }

        if (p.isParked()) {
            return "Vehicle already parked";
        }

        p.park(g);
        return "Parked successfully";
    }

    public void removeVehicle(int id) {
        Vehicle v = findVehicle(id);
        if (v == null) return;

        if (v instanceof Parkable) {
            Parkable p = (Parkable) v;
            if (p.isParked()) {
                p.unpark();
            }
        }

        vehicles.remove(v);
    }

    public ArrayList<Vehicle> getVehicles() {
        Collections.sort(vehicles, new VehicleComparator());
        return vehicles;
    }
}
