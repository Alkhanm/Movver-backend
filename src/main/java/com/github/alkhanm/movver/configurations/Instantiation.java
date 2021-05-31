package com.github.alkhanm.movver.configurations;

import com.github.alkhanm.movver.domain.*;
import com.github.alkhanm.movver.domain.design.patterns.states.FreightFinishedStatus;
import com.github.alkhanm.movver.domain.enums.FreightServiceEnum;
import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;
import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import com.github.alkhanm.movver.domain.enums.VehicleTruckBodyEnum;
import com.github.alkhanm.movver.domain.mapper.FreightMapper;
import com.github.alkhanm.movver.domain.transference.FreightResponse;
import com.github.alkhanm.movver.services.ClientService;
import com.github.alkhanm.movver.services.DriverService;
import com.github.alkhanm.movver.services.FreightService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {
    private final DriverService driverService;
    private final ClientService clientService;
    private final FreightService freightService;

    static List<Client> clients = List.of(
            new Client("Gabriela", "senha", "(22) 92343-1673",
                    Instant.parse("1987-02-20T21:20:41Z").toEpochMilli()),
            new Client("Joás", "123", "(99) 99999-9999",
                    Instant.parse("1998-11-11T11:11:11Z").toEpochMilli()),
            new Client("Pedro", "senha", "(61) 91243-5312",
                    Instant.parse("2001-07-10T21:20:41Z").toEpochMilli())
    );

    static List<Vehicle> vehicles = List.of(
            Vehicle.builder()
                    .licensePlate("Kdc5475")
                    .color("preto")
                    .capacity(6000)
                    .truckBodyWork(VehicleTruckBodyEnum.OPEN)
                    .model(VehicleModelEnum.TYPE3).build(),
            Vehicle.builder()
                    .licensePlate("Rbw0A48")
                    .color("branco")
                    .capacity(5500)
                    .truckBodyWork(VehicleTruckBodyEnum.CLOSED)
                    .model(VehicleModelEnum.TYPE2).build(),
            Vehicle.builder()
                    .licensePlate("Qtp0666")
                    .color("azul")
                    .capacity(10000)
                    .truckBodyWork(VehicleTruckBodyEnum.OPEN)
                    .model(VehicleModelEnum.TYPE6).build(),
            Vehicle.builder()
                    .licensePlate("Ngd9737")
                    .color("prata")
                    .capacity(1000)
                    .truckBodyWork(VehicleTruckBodyEnum.CLOSED)
                    .model(VehicleModelEnum.TYPE5).build(),
            Vehicle.builder()
                    .licensePlate("Gmz0117")
                    .color("laranja")
                    .capacity(2000)
                    .truckBodyWork(VehicleTruckBodyEnum.CLOSED)
                    .model(VehicleModelEnum.TYPE3).build()
    );
    static List<Driver> drivers = List.of(
            new Driver (
                    "Jorge", "senha", "(51) 96231-4618",
                    Instant.parse("1970-10-23T21:20:21Z").toEpochMilli(),
                    false,
                    new Location("Setor Garavelo", 0.2123, 0.2122),
                    vehicles.get(2)),
            new Driver (
                    "Rogerio", "senha", "(51) 96331-4612",
                    Instant.parse("1999-12-10T21:20:21Z").toEpochMilli(),
                    false,
                    new Location("Setor Veiga Jardim", 0.2123, 0.2122),
                    vehicles.get(1)),
            new Driver (
                    "Pedro", "senha", "(11) 94545-8214",
                    Instant.parse("1982-11-10T21:20:21Z").toEpochMilli(),
                    true,
                    new Location("Cruzeiro Sul", 0.2123, 0.2122),
                    vehicles.get(3)),
            new Driver ("Lucas", "senha", "(11) 96123-8242",
                    Instant.parse("1982-11-10T21:20:21Z").toEpochMilli(),
                    false,
                    new Location("Parque Itatiaia", 0.2123, 0.2122),
                    vehicles.get(4)),
            new Driver ("Matheus", "senha", "(61) 96331-1112",
                    Instant.parse("1982-11-10T21:20:21Z").toEpochMilli(),
                    true,
                    new Location("Parque Itatiaia", 0.2123, 0.2122),
                    vehicles.get(0))
    );

    static List<Freight> freights = List.of(
            new Freight(
                    clients.get(1),
                    drivers.get(0),
                    new Location("Rua João Bobo", 1.23, 1.123),
                    new Location("Rua Dom Pedro I", 1.3, 1.52),
                    Instant.parse("2021-03-10T21:20:21Z").toEpochMilli(),
                    Instant.parse("2021-03-10T21:20:41Z").toEpochMilli(),
                    55.0,
                    1000,
                    FreightServiceEnum.HOME_MOVING),
            new Freight(
                    clients.get(1),
                    drivers.get(2),
                    new Location("Rua João Bobo", 1.23, 1.123),
                    new Location("Rua Dom Pedro I", 1.3, 1.52),
                    Instant.parse("2021-03-10T21:20:21Z").toEpochMilli(),
                    Instant.parse("2021-02-10T21:20:41Z").toEpochMilli(),
                    55.0,
                    1000,
                    FreightServiceEnum.MATERIAL_TRANSPORT),
            new Freight(
                    clients.get(1),
                    drivers.get(1),
                    new Location("Avenida A-23", 1.323, 2.123),
                    new Location("Rua João Bobo", 1.323, 1.3),
                    Instant.parse("2021-03-10T21:20:21Z").toEpochMilli(),
                    Instant.parse("2021-03-10T21:20:41Z").toEpochMilli(),
                    55.0,
                    3000,
                    FreightServiceEnum.MATERIAL_TRANSPORT),
            new Freight(
                    clients.get(0),
                    drivers.get(2),
                    new Location("Rua Caraí", 1.233, 1.323),
                    new Location("Rua Santo Agostinho", 1.323, 1.03),
                    Instant.parse("2021-03-10T09:20:21Z").toEpochMilli(),
                    Instant.parse("2021-03-10T09:40:41Z").toEpochMilli(),
                    20.0,
                    4000,
                    FreightServiceEnum.MATERIAL_TRANSPORT)
    );

    public Instantiation(DriverService driverService, ClientService clientService, FreightService freightService) {
        this.driverService = driverService;
        this.clientService = clientService;
        this.freightService = freightService;
    }

    @Override
    public void run(String... args) {
        clients.forEach(clientService::save);
        drivers.forEach(driverService::save);
        freights.forEach(freightService::save);
    }
}
