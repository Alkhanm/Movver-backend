package com.github.alkhanm.movver.repositories;

import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.enums.FreightServiceEnum;
import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreightRepository extends JpaRepository<Freight, Long> {

    // Busca todos os fretes de um certo usuário pelo número de telefone
    @Query("SELECT f FROM Freight f WHERE f.client.phoneNumber = ?1 OR f.driver.phoneNumber = ?1")
    Page<Freight> findFreightsByUser(String phoneNumber, Pageable pageable);

    // Busca todos os fretes com o status requerido
    Page<Freight> findAllByStatus(FreightStatusEnum status, Pageable pageable);
}
