package dao;

import model.Vehicle;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class VehicleDao {

    @PersistenceContext
    private EntityManager entityManager;

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
