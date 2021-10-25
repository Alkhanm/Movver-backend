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

import java.time.Instant;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {
    private final DriverService driverService;
    private final ClientService clientService;
    private final FreightService freightService;

    public static Client client1 = new Client(1L, "Gabriela", "senha1223", "(22) 92343-1673",
            Instant.parse("1987-02-20T21:20:41Z").toEpochMilli());
    public static Client client2 = new Client(2L, "Joás", "senha101", "(99) 99999-9999",
            Instant.parse("1998-11-11T11:11:11Z").toEpochMilli());
    public static Client client3 = new Client(3L, "Pedro", "senha", "(61) 91243-5312",
            Instant.parse("2001-07-10T21:20:41Z").toEpochMilli());

    public static List<Vehicle> vehicles = List.of(
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
    public static List<Driver> drivers = List.of(
            new Driver(
                    "Jorge", "senha", "(51) 96231-4618",
                    Instant.parse("1970-10-23T21:20:21Z").toEpochMilli(),
                    false,
                    new Location("Setor Garavelo", 0.2123, 0.2122),
                    vehicles.get(2)),
            new Driver(
                    "Rogerio", "senha", "(51) 96331-4612",
                    Instant.parse("1999-12-10T21:20:21Z").toEpochMilli(),
                    false,
                    new Location("Setor Veiga Jardim", 0.2123, 0.2122),
                    vehicles.get(1)),
            new Driver(
                    "Pedro", "senha", "(11) 94545-8214",
                    Instant.parse("1982-11-10T21:20:21Z").toEpochMilli(),
                    true,
                    new Location("Cruzeiro Sul", 0.2123, 0.2122),
                    vehicles.get(3)),
            new Driver("Lucas", "senha", "(11) 96123-8242",
                    Instant.parse("1982-11-10T21:20:21Z").toEpochMilli(),
                    false,
                    new Location("Parque Itatiaia", 0.2123, 0.2122),
                    vehicles.get(4)),
            new Driver("Matheus", "senha", "(61) 96331-1112",
                    Instant.parse("1982-11-10T21:20:21Z").toEpochMilli(),
                    true,
                    new Location("Parque Itatiaia", 0.2123, 0.2122),
                    vehicles.get(0))
    );

    public static List<Freight> freights = List.of(
            new Freight(
                    1L,
                    client2,
                    drivers.get(0),
                    new Location("Rua João Bobo", 1.23, 1.123),
                    new Location("Rua Dom Pedro I", 1.3, 1.52),
                    Instant.parse("2020-03-10T21:20:21Z").toEpochMilli(),
                    Instant.parse("2020-03-10T21:20:41Z").toEpochMilli(),
                    30,
                    2000,
                    FreightServiceEnum.HOME_MOVING,
                    FreightStatusEnum.FINISHED,
                    "").confirm().start().finish(),
            new Freight(
                    2L,
                    client2,
                    drivers.get(2),
                    new Location("Rua João Bobo", 1.23, 1.123),
                    new Location("Rua Dom Pedro I", 1.3, 1.52),
                    Instant.parse("2021-10-07T20:20:21Z").toEpochMilli(),
                    Instant.parse("2021-10-07T21:20:41Z").toEpochMilli(),
                    30.0,
                    2000,
                    FreightServiceEnum.MATERIAL_TRANSPORT,
                    FreightStatusEnum.FINISHED,
                    "").confirm().start().finish(),
            new Freight(
                    3L,
                    client1,
                    drivers.get(1),
                    new Location("Avenida A-23", 1.323, 2.123),
                    new Location("Rua João Bobo", 1.323, 1.3),
                    Instant.parse("2021-10-11T11:20:21Z").toEpochMilli(),
                    Instant.parse("2021-10-11T11:26:41Z").toEpochMilli(),
                    55.0,
                    3000,
                    FreightServiceEnum.MATERIAL_TRANSPORT,
                    FreightStatusEnum.FINISHED,
                    "").confirm().cancel(),
            new Freight(
                    3L,
                    client3,
                    drivers.get(2),
                    new Location("Rua Javaí", 1.233, 1.323),
                    new Location("Rua Santo Agostinho", 1.323, 1.03),
                    Instant.parse("2021-01-10T09:20:21Z").toEpochMilli(),
                    Instant.parse("2021-01-10T09:40:41Z").toEpochMilli(),
                    20.0,
                    4000,
                    FreightServiceEnum.MATERIAL_TRANSPORT,
                    FreightStatusEnum.CONFIRMED,
                    "").confirm().start().finish()
    );

    public Instantiation(DriverService driverService, ClientService clientService, FreightService freightService) {
        this.driverService = driverService;
        this.clientService = clientService;
        this.freightService = freightService;
    }

    @Override
    public void run(String... args) {
        clientService.save(client1);
        clientService.save(client2);
        clientService.save(client3);
        drivers.forEach(driverService::save);
        freights.forEach(freightService::save);
    }
}
