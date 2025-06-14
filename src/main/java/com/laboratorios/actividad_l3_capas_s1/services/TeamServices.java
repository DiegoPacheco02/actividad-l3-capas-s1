package com.laboratorios.actividad_l3_capas_s1.services;

import com.laboratorios.actividad_l3_capas_s1.dto.QueryTeamsDto;
import com.laboratorios.actividad_l3_capas_s1.dto.RegisterTeamDto;
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
  
    public void createTeam(RegisterTeamDto teamDto) {
        Team newTeam = new Team();
        newTeam.setName(teamDto.getName());
        newTeam.setCountry(teamDto.getCountry());
        newTeam.setCoach(teamDto.getCoach());
        newTeam.setTitles(teamDto.getTitles());

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
        teamRepository.save(newTeam);

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
