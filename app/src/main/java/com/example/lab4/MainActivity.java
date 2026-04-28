// Samborska Anastasiia, lab 8-11 (SET 4), 55936
package com.example.lab4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Rental rental;
    private TextView txtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rental = new Rental(5);

        EditText etName = findViewById(R.id.etName);
        EditText etType = findViewById(R.id.etType);
        EditText etFuel = findViewById(R.id.etFuel);
        EditText etFuelAmount = findViewById(R.id.etFuelAmount);
        EditText etVehicleId = findViewById(R.id.etVehicleId);
        EditText etGarage = findViewById(R.id.etGarage);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnPark = findViewById(R.id.btnPark);
        Button btnRemove = findViewById(R.id.btnRemove);

        txtOutput = findViewById(R.id.txtOutput);

        
        btnAdd.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String type = etType.getText().toString().toLowerCase();

            Vehicle vehicle = null;

            try {
                switch (type) {

                    case "car": {
                        int fuelMask = Integer.parseInt(etFuel.getText().toString());
                        double fuelAmount = Double.parseDouble(etFuelAmount.getText().toString());

                        Car car = new Car(name, fuelMask);

                        if (!car.refuel(fuelMask, fuelAmount)) {
                            show("Wrong fuel type!");
                            return;
                        }

                        vehicle = car;
                        break;
                    }

                    case "motorboat": {
                        int fuelMask = Integer.parseInt(etFuel.getText().toString());
                        double fuelAmount = Double.parseDouble(etFuelAmount.getText().toString());

                        Motorboat m = new Motorboat(name, fuelMask);

                        if (!m.refuel(fuelMask, fuelAmount)) {
                            show("Wrong fuel type!");
                            return;
                        }

                        vehicle = m;
                        break;
                    }

                    case "bicycle":
                        vehicle = new Bicycle(name);
                        break;

                    case "scooter":
                        vehicle = new Scooter(name);
                        break;

                    default:
                        show("Invalid type!");
                        return;
                }

                rental.addVehicle(vehicle);
                show("Vehicle added!");
                updateOutput();

            } catch (Exception e) {
                show("Check input!");
            }
        });

        
        btnPark.setOnClickListener(v -> {
            try {
                int id = Integer.parseInt(etVehicleId.getText().toString());
                int garageNum = Integer.parseInt(etGarage.getText().toString());

                String result = rental.parkVehicle(id, garageNum);
                show(result);
                updateOutput();

            } catch (Exception e) {
                show("Invalid input!");
            }
        });

        
        btnRemove.setOnClickListener(v -> {
            try {
                int id = Integer.parseInt(etVehicleId.getText().toString());

                rental.removeVehicle(id);
                show("Vehicle removed");
                updateOutput();

            } catch (Exception e) {
                show("Invalid ID!");
            }
        });

        updateOutput();
    }

    private void updateOutput() {
        StringBuilder sb = new StringBuilder();

        for (Vehicle v : rental.getVehicles()) {
            sb.append(v.toString()).append("\n\n");
        }

        txtOutput.setText(sb.toString());
    }

    private void show(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
