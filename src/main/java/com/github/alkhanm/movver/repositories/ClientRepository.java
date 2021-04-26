package com.github.alkhanm.movver.repositories;

import com.github.alkhanm.movver.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends EntityRepository<Client> {}
