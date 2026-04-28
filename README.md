## Course name: Introduction to mobile system L1
#### Lab number: From 8-11 (SET 4)
#### Student name: Samborska Anastasiia
#### Student ID: 55936
#### Short description of the app: This app is a vehicle rental system built using object-oriented programming principles. It allows users to add different types of vehicles (car, motorboat, bicycle, scooter), park them in garages, remove them, and view all vehicles. The system uses interfaces, inheritance, polymorphism, and stores data in an ArrayList.
#### Describe the hardest technical issue you faced and how you solved it: The hardest issue was implementing fuel handling using a bitmask and the refuel() method. Initially, the fuel amount was always 0 because it was not being updated correctly. I solved this by using the refuel() method when creating vehicles and ensuring that the fuel type is validated using bitwise operations before adding fuel.
#### Note: the screenshots in the screenshots folder.

### java classes and interfaces: (app -> src -> main -> java -> com.example.lab4)
- MainActivity
- Bicycle
- Car
- CombustionVehicle
- Garage
- Motorboat
- Parkable
- Rental
- Scooter
- Vehicle
- VehicleComparator