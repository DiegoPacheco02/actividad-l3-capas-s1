package com.laboratorios.actividad_l3_capas_s1.controllers;

import com.laboratorios.actividad_l3_capas_s1.dto.QueryTeamsDto;
import com.laboratorios.actividad_l3_capas_s1.services.TeamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamServices teamServices;

    @Autowired
    public TeamController(TeamServices teamServices) {
        this.teamServices = teamServices;
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<QueryTeamsDto> getClubsByCountry(@PathVariable("country") String country){
        try {
            QueryTeamsDto team = teamServices.getClubsByCountry(country);
            return ResponseEntity.ok(team);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
