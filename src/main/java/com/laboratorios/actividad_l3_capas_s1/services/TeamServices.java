package com.laboratorios.actividad_l3_capas_s1.services;

import com.laboratorios.actividad_l3_capas_s1.dto.QueryTeamsDto;
import com.laboratorios.actividad_l3_capas_s1.model.Team;
import com.laboratorios.actividad_l3_capas_s1.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServices {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServices(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public QueryTeamsDto getClubsByCountry(String country){

        Team team = teamRepository.findByCountry(country)
                .orElseThrow(() -> new IllegalArgumentException("Country not found"));

        return new QueryTeamsDto(
                team.getId(),
                team.getName(),
                team.getCountry(),
                team.getCoach(),
                team.getTitles()
        );
    }

}
