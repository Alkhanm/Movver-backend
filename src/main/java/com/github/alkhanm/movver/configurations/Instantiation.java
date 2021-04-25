package com.github.alkhanm.movver.configurations;

import com.github.alkhanm.movver.domain.entities.Client;
import com.github.alkhanm.movver.domain.entities.Driver;
import com.github.alkhanm.movver.domain.entities.Vehicle;
import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import com.github.alkhanm.movver.services.ClientService;
import com.github.alkhanm.movver.services.DriverService;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.Encoder;
import java.time.LocalDateTime;
import java.util.Arrays;
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
                Client.builder().name("Gabriela").password("senha").phoneNumber("22 92343-1673")
                        .birthDate(LocalDateTime.of(2001, 3, 1, 0,0)).build(),
                Client.builder().name("Joás").password("senha").phoneNumber("62 92343-4153")
                        .birthDate(LocalDateTime.of(1992, 11, 30, 0,0)).build(),
                Client.builder().name("Pedro").password("senha").phoneNumber("61 91243-5312")
                        .birthDate(LocalDateTime.of(1999, 12, 10, 0,0)).build()
        );
        List<Vehicle> vehicles = List.of(
                Vehicle.builder().licensePlate("Kdc5475").color("preto").capacity(6000).truckBodyWorkOpen(true)
                        .model(VehicleModelEnum.TYPE_3).build(),
                Vehicle.builder().licensePlate("Rbw0A48").color("branco").capacity(5500).truckBodyWorkOpen(false)
                        .model(VehicleModelEnum.TYPE_2).build(),
                Vehicle.builder().licensePlate("Qtp0666").color("azul").capacity(10000).truckBodyWorkOpen(true)
                        .model(VehicleModelEnum.TYPE_6).build(),
                Vehicle.builder().licensePlate("Ngd9737").color("prata").capacity(1000).truckBodyWorkOpen(false)
                        .model(VehicleModelEnum.TYPE_5).build(),
                Vehicle.builder().licensePlate("Gmz0117").color("laranja").capacity(2000).truckBodyWorkOpen(true)
                        .model(VehicleModelEnum.TYPE_3).build()

        );
        List<Driver> drivers = List.of(
                Driver.builder().name("Marcos").password("senha").phoneNumber("63 96521-4312").location("0.1233, 0.755")
                        .vehicle(vehicles.get(1)).build(),
                Driver.builder().name("Rogerio").password("senha").phoneNumber("51 96331-4612").location("0.2123, 0.2122")
                        .vehicle(vehicles.get(2)).build(),
                Driver.builder().name("Pedro").password("senha").phoneNumber("11 94545-8214").location("0.342, 0.32")
                        .vehicle(vehicles.get(3)).build(),
                Driver.builder().name("Lucas").password("senha").phoneNumber("11 96123-8242").location("0.312, 0.23")
                        .vehicle(vehicles.get(4)).build(),
                Driver.builder().name("Matheus").password("senha").phoneNumber("61 96331-1112").location("0.123, 0.02")
                        .vehicle(vehicles.get(0)).build()
        );
        clients.forEach(clientService::save);
        drivers.forEach(driverService::save);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
