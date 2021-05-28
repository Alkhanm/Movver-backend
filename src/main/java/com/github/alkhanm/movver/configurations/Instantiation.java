package com.github.alkhanm.movver.configurations;

import com.github.alkhanm.movver.domain.entities.Client;
import com.github.alkhanm.movver.domain.entities.Driver;
import com.github.alkhanm.movver.domain.entities.Vehicle;
import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import com.github.alkhanm.movver.domain.enums.VehicleTruckBodyEnum;
import com.github.alkhanm.movver.services.ClientService;
import com.github.alkhanm.movver.services.DriverService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {
    private final DriverService driverService;
    private final ClientService clientService;

    public Instantiation(DriverService driverService, ClientService clientService) {
        this.driverService = driverService;
        this.clientService = clientService;
    }

    @Override
    public void run(String... args) {
        List<Client> clients = List.of(
                new Client("Gabriela", "senha", "(22) 92343-1673", LocalDateTime.of(2001, 3, 1, 0,0)),
                new Client("Joás", "senha", "(99) 99999-9999", LocalDateTime.of(1992, 11, 26, 0,0)),
                new Client("Pedro", "senha", "(61) 91243-5312", LocalDateTime.of(1999, 12, 10, 0,0))

        );
        List<Vehicle> vehicles = List.of(
                Vehicle.builder().licensePlate("Kdc5475").color("preto").capacity(6000).truckBodyWork(VehicleTruckBodyEnum.OPEN)
                        .model(VehicleModelEnum.TYPE_3).build(),
                Vehicle.builder().licensePlate("Rbw0A48").color("branco").capacity(5500).truckBodyWork(VehicleTruckBodyEnum.CLOSED)
                        .model(VehicleModelEnum.TYPE_2).build(),
                Vehicle.builder().licensePlate("Qtp0666").color("azul").capacity(10000).truckBodyWork(VehicleTruckBodyEnum.OPEN)
                        .model(VehicleModelEnum.TYPE_6).build(),
                Vehicle.builder().licensePlate("Ngd9737").color("prata").capacity(1000).truckBodyWork(VehicleTruckBodyEnum.CLOSED)
                        .model(VehicleModelEnum.TYPE_5).build(),
                Vehicle.builder().licensePlate("Gmz0117").color("laranja").capacity(2000).truckBodyWork(VehicleTruckBodyEnum.CLOSED)
                        .model(VehicleModelEnum.TYPE_3).build()
        );
        List<Driver> drivers = List.of(
                new Driver ("Jorge", "senha", "(51) 96231-4618",
                        LocalDateTime.of(1989, 12, 10, 0,0),
                        false,
                        "0.2123, 0.2122",
                        vehicles.get(2)),
                new Driver ("Rogerio", "senha", "(51) 96331-4612",
                         LocalDateTime.of(1999, 12, 10, 0,0),
                         false,
                        "0.2123, 0.2122",
                         vehicles.get(1)),
                new Driver ("Pedro", "senha", "(11) 94545-8214",
                         LocalDateTime.of(1999, 12, 10, 0,0),
                         true,
                        "0.342, 0.32",
                         vehicles.get(3)),
                new Driver ("Lucas", "senha", "(11) 96123-8242",
                         LocalDateTime.of(1999, 12, 10, 0,0),
                         false,
                        "0.312, 0.23",
                         vehicles.get(4)),
                new Driver ("Matheus", "senha", "(61) 96331-1112",
                         LocalDateTime.of(1999, 12, 10, 0,0),
                         true,
                        "0.123, 0.02",
                         vehicles.get(0))
        );
        clients.forEach(clientService::save);
        drivers.forEach(driverService::save);
    }
}
