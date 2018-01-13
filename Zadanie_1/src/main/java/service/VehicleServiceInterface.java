package service;

import model.Vehicle;

public interface VehicleServiceInterface {
    Vehicle update(Vehicle vehicle);
    Vehicle get(Long id);

    Vehicle getAll();

    Vehicle add(Vehicle vehicle);

    Vehicle delete(Long id);
}
