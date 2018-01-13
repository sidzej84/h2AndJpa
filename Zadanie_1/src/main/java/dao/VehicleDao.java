package dao;

import model.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class VehicleDao {
    public Vehicle update(Vehicle vehicle) {
        return null;
    }

    public Vehicle get(Long vehicleId) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleId);
        return vehicle;
    }

    public Vehicle add(Vehicle vehicle) {
        return null;
    }

    public Vehicle delete(Long vehicleId) {
        return null;
    }

    public Vehicle getAll(Long vehicleId) {
        return null;
    }

}
