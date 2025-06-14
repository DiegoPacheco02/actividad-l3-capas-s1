package com.laboratorios.actividad_l3_capas_s1.repositories;

import com.laboratorios.actividad_l3_capas_s1.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TeamRepository extends JpaRepository<Team, UUID> {

    Optional<Team> findByCountry(String country);
    Team findByName(String name);
}
