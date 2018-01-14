package service;

import dao.VehicleDao;
import model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class VehicleService implements VehicleServiceInterface {
    private VehicleDao vehicleDao;
    @Autowired
    public VehicleService(VehicleDao vehicleDao) {
    this.vehicleDao = vehicleDao;
    }
    @Override
    public Vehicle update(Vehicle vehicle){
        Vehicle fetchedVehicle = vehicleDao.get(vehicle.getId());
        if (fetchedVehicle == null) {
            throw new IdNotFoundException();
        }

        return vehicleDao.update(vehicle);

    }

    @Override
    public Vehicle get(Long id) {
        return null;
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleDao.getAll();
    }

    @Override
    public Vehicle add(Vehicle vehicle) {
        return vehicleDao.add(vehicle);
    }

    @Override
    public Vehicle delete(Long id) {
        return  vehicleDao.delete(id);
    }




}

