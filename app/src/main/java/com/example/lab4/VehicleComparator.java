package com.example.lab4;
import java.util.Comparator;

public class VehicleComparator implements Comparator<Vehicle>{

        @Override
        public int compare(Vehicle a, Vehicle b) {

            boolean aParked = false;
            boolean bParked = false;

            if (a instanceof Parkable) {
                aParked = ((Parkable) a).isParked();
            }

            if (b instanceof Parkable) {
                bParked = ((Parkable) b).isParked();
            }

         
            if (aParked != bParked) {
                return bParked ? 1 : -1;
            }

       
            int typeCompare = getTypeOrder(a) - getTypeOrder(b);
            if (typeCompare != 0) return typeCompare;

        
            int nameCompare = a.getName().compareTo(b.getName());
            if (nameCompare != 0) return nameCompare;

         
            int fuelTypeA = (a instanceof CombustionVehicle)
                    ? ((CombustionVehicle) a).getSupportedFuelMask() : 0;

            int fuelTypeB = (b instanceof CombustionVehicle)
                    ? ((CombustionVehicle) b).getSupportedFuelMask() : 0;

            int fuelTypeCompare = Integer.compare(fuelTypeA, fuelTypeB);
            if (fuelTypeCompare != 0) return fuelTypeCompare;

            double fuelA = (a instanceof CombustionVehicle)
                    ? ((CombustionVehicle) a).getFuelAmount() : 0;

            double fuelB = (b instanceof CombustionVehicle)
                    ? ((CombustionVehicle) b).getFuelAmount() : 0;

            return Double.compare(fuelA, fuelB);
        }

        private int getTypeOrder(Vehicle v) {
            if (v instanceof Car) return 1;
            if (v instanceof Motorboat) return 2;
            if (v instanceof Bicycle) return 3;
            return 4;
        }

}
