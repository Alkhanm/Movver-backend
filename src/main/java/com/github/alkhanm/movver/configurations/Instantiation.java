package com.github.alkhanm.movver.configurations;

import com.github.alkhanm.movver.domain.entities.Client;
import com.github.alkhanm.movver.domain.entities.Driver;
import com.github.alkhanm.movver.domain.entities.Vehicle;
import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import com.github.alkhanm.movver.services.ClientService;
import com.github.alkhanm.movver.services.DriverService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {
    final DriverService driverService;
    final ClientService clientService;

    public Instantiation(DriverService driverService, ClientService clientService) {
        this.driverService = driverService;
        this.clientService = clientService;
    }

    @Override
    public void run(String... args) {
        List<Client> clients = List.of(
                Client.builder().id(1).name("Gabriela").birthDate(LocalDateTime.of(2001, 3, 1, 0,0))
                       .phoneNumber("22 92343-1673").build(),
                Client.builder().id(2).name("Joás").birthDate(LocalDateTime.of(1992, 11, 30, 0,0))
                        .phoneNumber("62 92343-4153").build(),
                Client.builder().id(3).name("Pedro").birthDate(LocalDateTime.of(1999, 12, 10, 0,0))
                        .phoneNumber("61 91243-5312").build()
        );
        List<Driver> drivers = List.of(
                Driver.builder().id(1).name("Marcos").phoneNumber("63 96521-4312").location("0.1233, 0.755").
                        vehicle(Vehicle.builder().capacity(6000).truckBodyWorkOpen(true).model(VehicleModelEnum.TYPE_3).build()).build(),
                Driver.builder().id(2).name("Rogerio").phoneNumber("51 96331-4612").location("0.2123, 0.2122")
                        .vehicle(Vehicle.builder().capacity(5500).truckBodyWorkOpen(false).model(VehicleModelEnum.TYPE_2).build()).build(),
                Driver.builder().id(3).name("Pedro").phoneNumber("11 94545-8214").location("0.342, 0.32")
                        .vehicle(Vehicle.builder().capacity(10000).truckBodyWorkOpen(true).model(VehicleModelEnum.TYPE_6).build()).build(),
                Driver.builder().id(4).name("Lucas").phoneNumber("11 96123-8242").location("0.312, 0.23")
                        .vehicle(Vehicle.builder().capacity(1000).truckBodyWorkOpen(false).model(VehicleModelEnum.TYPE_5).build()).build(),
                Driver.builder().id(5).name("Matheus").phoneNumber("\"61 96331-1112").location("0.123, 0.02")
                        .vehicle(Vehicle.builder().capacity(2000).truckBodyWorkOpen(true).model(VehicleModelEnum.TYPE_3).build()).build()
        );
        drivers.forEach(driverService::save);
        clients.forEach(clientService::save);
    }
}
