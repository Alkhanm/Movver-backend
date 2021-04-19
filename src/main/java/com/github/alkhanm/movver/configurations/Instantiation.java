package com.github.alkhanm.movver.configurations;

import com.github.alkhanm.movver.domain.entities.Driver;
import com.github.alkhanm.movver.domain.entities.Vehicle;
import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import com.github.alkhanm.movver.services.DriverService;
import com.github.alkhanm.movver.services.request.DriverRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {
    final DriverService driverService;

    public Instantiation(DriverService driverService) {
        this.driverService = driverService;
    }
    @Override
    public void run(String... args) {
        List<Driver> drivers = List.of(
                Driver.builder().name("Marcos").phoneNumber("63 96521-4312").location("0.1233, 0.755").password("abc101").
                        vehicle(Vehicle.builder().capacity(6000).truckBodyWorkOpen(true).model(VehicleModelEnum.TYPE_3).build()).build(),
                Driver.builder().name("Rogerio").phoneNumber("51 96331-4612").location("0.2123, 0.2122").password("abc101")
                        .vehicle(Vehicle.builder().capacity(5500).truckBodyWorkOpen(false).model(VehicleModelEnum.TYPE_2).build()).build(),
                Driver.builder().name("Pedro").phoneNumber("11 94545-8214").location("0.342, 0.32").password("abc101")
                        .vehicle(Vehicle.builder().capacity(10000).truckBodyWorkOpen(true).model(VehicleModelEnum.TYPE_6).build()).build(),
                Driver.builder().name("Lucas").phoneNumber("11 96123-8242").location("0.312, 0.23").password("abc101")
                        .vehicle(Vehicle.builder().capacity(1000).truckBodyWorkOpen(false).model(VehicleModelEnum.TYPE_5).build()).build(),
                Driver.builder().name("Matheus").phoneNumber("\"61 96331-1112").location("0.123, 0.02").password("abc101")
                        .vehicle(Vehicle.builder().capacity(2000).truckBodyWorkOpen(true).model(VehicleModelEnum.TYPE_3).build()).build()
        );
        drivers.forEach(driverService::save);
    }
}
