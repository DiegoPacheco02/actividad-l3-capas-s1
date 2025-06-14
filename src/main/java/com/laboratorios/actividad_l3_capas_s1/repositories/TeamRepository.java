package com.laboratorios.actividad_l3_capas_s1.repositories;

import com.laboratorios.actividad_l3_capas_s1.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {


}
