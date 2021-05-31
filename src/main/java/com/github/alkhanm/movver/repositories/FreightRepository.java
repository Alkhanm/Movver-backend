package com.github.alkhanm.movver.repositories;

import com.github.alkhanm.movver.domain.Client;
import com.github.alkhanm.movver.domain.Driver;
import com.github.alkhanm.movver.domain.Freight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreightRepository extends JpaRepository<Freight, Long> {
    List<Freight> findFreightByClient(Client client);
    List<Freight> findFreightByDriver(Driver driver);
}