package com.laboratorios.actividad_l3_capas_s1.services;

import com.laboratorios.actividad_l3_capas_s1.dto.QueryTeamsDto;
import com.laboratorios.actividad_l3_capas_s1.model.Team;
import com.laboratorios.actividad_l3_capas_s1.repositories.TeamRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServices {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServices(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public QueryTeamsDto getTeamByName(String name) {
        Team team = teamRepository.findByName(name);
        if (team == null) throw new NoResultException("Team not found with name: " + name);

        QueryTeamsDto queryTeamsDto = new QueryTeamsDto();
        queryTeamsDto.setId(team.getId());
        queryTeamsDto.setName(team.getName());
        queryTeamsDto.setCountry(team.getCountry());
        queryTeamsDto.setCoach(team.getCoach());
        queryTeamsDto.setTitles(team.getTitles());

        return queryTeamsDto;

    }
}
