package com.github.alkhanm.movver.configurations;

import com.github.alkhanm.movver.domain.entities.Vehicle;
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
        List<DriverRequest> drivers = List.of(
                new DriverRequest("Marcos", "0.123, 0.02", true, "63 96521-4312", "abc101", new Vehicle()),
                new DriverRequest("Rogerio", "0.123, 0.02", true, "51 96331-4612", "abc101", new Vehicle()),
                new DriverRequest("Pedro", "0.123, 0.02", true, "11 96545-8214", "abc101", new Vehicle()),
                new DriverRequest("Lucas", "0.123, 0.02", true, "11 96533-8242", "abc101", new Vehicle()),
                new DriverRequest("Matheus", "0.123, 0.02", true, "61 96331-1112", "abc101", new Vehicle()),
                new DriverRequest("Marcio", "0.123, 0.02", true, "12 94581-0012", "abc101", new Vehicle())
        );
        drivers.forEach(driverService::save);
    }
}
