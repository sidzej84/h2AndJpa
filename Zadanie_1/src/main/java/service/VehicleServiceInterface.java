package service;

import model.Vehicle;

import java.util.List;

public interface VehicleServiceInterface {
    Vehicle update(Vehicle vehicle);
    Vehicle get(Long id);

    List<Vehicle> getAll();

    Vehicle add(Vehicle vehicle);

    Vehicle delete(Long id);
}
