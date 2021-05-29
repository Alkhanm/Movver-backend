package com.github.alkhanm.movver.configurations;

import com.github.alkhanm.movver.domain.*;
import com.github.alkhanm.movver.domain.enums.FreightServiceEnum;
import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;
import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import com.github.alkhanm.movver.domain.enums.VehicleTruckBodyEnum;
import com.github.alkhanm.movver.services.ClientService;
import com.github.alkhanm.movver.services.DriverService;
import com.github.alkhanm.movver.services.FreightService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {
    private final DriverService driverService;
    private final ClientService clientService;
    private final FreightService freightService;

    public Instantiation(DriverService driverService, ClientService clientService, FreightService freightService) {
        this.driverService = driverService;
        this.clientService = clientService;
        this.freightService = freightService;
    }

    @Override
    public void run(String... args) {
        List<Client> clients = List.of(
                new Client("Gabriela", "senha", "(22) 92343-1673", LocalDateTime.of(2001, 3, 1, 0,0)),
                new Client("Joás", "123", "(99) 99999-9999", LocalDateTime.of(1999, 9, 28, 0,0)),
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
                        new Location("Setor Garavelo", 0.2123, 0.2122),
                        vehicles.get(2)),
                new Driver ("Rogerio", "senha", "(51) 96331-4612",
                         LocalDateTime.of(1999, 12, 10, 0,0),
                         false,
                        new Location("Setor Veiga Jardim", 0.2123, 0.2122),
                         vehicles.get(1)),
                new Driver ("Pedro", "senha", "(11) 94545-8214",
                         LocalDateTime.of(1999, 12, 10, 0,0),
                         true,
                        new Location("Cruzeiro Sul", 0.2123, 0.2122),
                         vehicles.get(3)),
                new Driver ("Lucas", "senha", "(11) 96123-8242",
                         LocalDateTime.of(1999, 12, 10, 0,0),
                         false,
                        new Location("Parque Itatiaia", 0.2123, 0.2122),
                         vehicles.get(4)),
                new Driver ("Matheus", "senha", "(61) 96331-1112",
                         LocalDateTime.of(1999, 12, 10, 0,0),
                         true,
                        new Location("Parque Itatiaia", 0.2123, 0.2122),
                         vehicles.get(0))
        );

        List<Freight> freights = List.of(
                new Freight(
                        "12:30 29/05/2021", "12:30 29/05/2021",
                        55.0,
                        FreightStatusEnum.TYPE_1, FreightServiceEnum.TYPE_1, 1000, 0, "", new Location("Rua João Bobo", 1.23, 1.123),
                        new Location("Rua Dom Pedro I", 1.3, 1.52),
                        clients.get(1), drivers.get(0)
                ),
                new Freight(
                        "7:30 29/05/2021", "08:30 29/05/2021",
                        55.0,
                        FreightStatusEnum.TYPE_2, FreightServiceEnum.TYPE_1, 3000, 0, "", new Location("Avenida A-23", 1.323, 2.123),
                        new Location("Rua João Bobo", 1.323, 1.3),
                        clients.get(1), drivers.get(2)
                ),
                new Freight(
                        "12:31 29/05/2021", "14:23 29/05/2021",
                        55.0,
                        FreightStatusEnum.TYPE_3, FreightServiceEnum.TYPE_1, 4000, 0, "", new Location("Rua Caraí", 1.233, 1.323),
                        new Location("Rua Santo Agostinho", 1.323, 1.03),
                        clients.get(0), drivers.get(1)
                )
        );
        clients.forEach(clientService::save);
        drivers.forEach(driverService::save);
        freights.forEach(freightService::save);
    }
}
