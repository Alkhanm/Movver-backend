package com.github.alkhanm.movver.repositories;

import com.github.alkhanm.movver.domain.entities.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends UserRepository<Client> {}
