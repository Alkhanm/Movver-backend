package com.github.alkhanm.movver.repositories;

import com.github.alkhanm.movver.domain.entities.Freight;
import com.github.alkhanm.movver.domain.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreightRepository extends JpaRepository<Freight, Long> {}
