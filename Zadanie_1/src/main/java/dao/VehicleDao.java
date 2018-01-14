package dao;

import model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class VehicleDao {

    @Autowired
    EntityManager entityManager;

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

    public List<Vehicle> getAll() {
        final Query query = entityManager.createQuery("from Vehicle", Vehicle.class);
        return query.getResultList();
    }

}
