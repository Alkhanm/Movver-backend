package com.github.alkhanm.movver.integration;

import com.github.alkhanm.movver.domain.*;
import com.github.alkhanm.movver.domain.enums.FreightServiceEnum;
import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;
import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import com.github.alkhanm.movver.domain.enums.VehicleTruckBodyEnum;
import com.github.alkhanm.movver.domain.transference.PageableResponse;
import com.github.alkhanm.movver.repositories.ClientRepository;
import com.github.alkhanm.movver.repositories.DriverRepository;
import com.github.alkhanm.movver.repositories.FreightRepository;
import com.github.alkhanm.movver.utils.EntityCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.annotation.DirtiesContext;

import java.time.Instant;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class FreightControllerTest {

    @Qualifier(value = "testRestTemplate")
    @Autowired private TestRestTemplate testRestTemplate;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired private DriverRepository driverRepository;

    @Autowired private FreightRepository repository;

    private static final Client CLIENT = new Client("Marcos", "(99) 99999-9999", "senha", Instant.parse("2001-07-10T21:20:41Z").toEpochMilli());

    @TestConfiguration
    @Lazy
    static class Config {
        @Bean(name = "testRestTemplate")
        public TestRestTemplate testRestTemplateUserCreator(@Value("${local.server.port}") int port) {
            RestTemplateBuilder restTemplate = new RestTemplateBuilder()
                    .rootUri("http://localhost:" + port)
                    .additionalInterceptors((request, body, execution) -> {
                        request.getHeaders().add("Bearer", "eyJhbGciOiJIUzUxMiJ9.eyJpZCI6Miwic3ViIjoiOTk5OTk5OTk5OTkiLCJleHAiOjE2Mzk2NzMyNTd9.uxNOipXI6hsVunfthrqDBmN_HIdSeX30fpr4VCh0xtHu7ItinK7P9OuFaAR1B_2aAZ77wXdo7DRuz-qNMquEuQ");
                        return execution.execute(request, body);
                    });
            return new TestRestTemplate(restTemplate);
        }
    }

    @TestConfiguration
    static class ConfigDatabase {
        private final DriverRepository driverRepository;
        private final ClientRepository clientRepository;
        private final FreightRepository freightRepository;

        ConfigDatabase(DriverRepository driverRepository, ClientRepository clientRepository, FreightRepository freightRepository) {
            this.driverRepository = driverRepository;
            this.clientRepository = clientRepository;
            this.freightRepository = freightRepository;
        }

        @Bean
        public void saveEntities() {

            List<Client> clients = List.of(
                    new Client("Gabriela", "senha1223", "(22) 92343-1673",
                            Instant.parse("1987-02-20T21:20:41Z").toEpochMilli()),
                    new Client("Joás", "senha101", "(99) 99999-9999",
                            Instant.parse("1998-11-11T11:11:11Z").toEpochMilli()),
                    new Client("Pedro", "senha", "(61) 91243-5312",
                            Instant.parse("2001-07-10T21:20:41Z").toEpochMilli())
            );

            List<Vehicle> vehicles = List.of(
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
            List<Driver> drivers = List.of(
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

            List<Freight> freights = List.of(
                    new Freight(
                            1L,
                            clients.get(1),
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
                            clients.get(1),
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
                            clients.get(0),
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
                            clients.get(2),
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


            clientRepository.saveAll(clients);
            driverRepository.saveAll(drivers);
            freightRepository.saveAll(freights);

        }
    }


    @Test
    @DisplayName("Retorna uma lista de fretes")
    void getAllTest() {
        clientRepository.save(CLIENT);

        String expectedName = EntityCreator.freightList().get(0).getClient().getName();

        PageableResponse<Freight> freightPage = testRestTemplate
                .exchange("/freights", HttpMethod.GET, null, new ParameterizedTypeReference<PageableResponse<Freight>>(){})
                .getBody();

        Assertions.assertThat(freightPage)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(freightPage.toList().get(0).getClient().getName())
                .isEqualTo(expectedName);

    }
}
