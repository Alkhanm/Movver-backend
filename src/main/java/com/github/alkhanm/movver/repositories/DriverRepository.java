package com.github.alkhanm.movver.repositories;

import com.github.alkhanm.movver.domain.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends EntityRepository<Driver> {}
