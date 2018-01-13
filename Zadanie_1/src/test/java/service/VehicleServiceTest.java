package service;

import dao.VehicleDao;
import model.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.*;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceTest {

    @Mock
    VehicleDao vehicleDao;
    @Mock
    Vehicle vehicle;

    @InjectMocks
    VehicleService vehicleService;

    @Before
    public void init(){
        when(vehicleDao.get(1l)).thenReturn(vehicle);
        when(vehicle.getId()).thenReturn(1l);
    }

    @Test(expected = IdNotFoundException.class)
    public void shouldThrowExceptionWhenUpdatedVehicleIdNotFound() {
        // given
        when(vehicleDao.get(1l)).thenReturn(null);

        // when
        vehicleService.update(vehicle);

        // then
    }

    @Test
    public void shouldUpdateVehicleAndReturnUpdatedVehicle() {
        // given
        when(vehicleDao.update(vehicle)).thenReturn(vehicle);

        // when
        Vehicle updatedVehicle = vehicleService.update(vehicle);

        // then
        verify(vehicleDao).update(vehicle);
        assertThat(updatedVehicle).isEqualTo(vehicle);
    }
}