package com.laboratorios.actividad_l3_capas_s1.controllers;

import com.laboratorios.actividad_l3_capas_s1.dto.QueryTeamsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.laboratorios.actividad_l3_capas_s1.dto.RegisterTeamDto;
import com.laboratorios.actividad_l3_capas_s1.services.*;

@RestController
@RequestMapping("/api/clubs")
public class TeamController {

    private final TeamServices teamServices;

    @Autowired
    public TeamController(TeamServices teamServices) {
        this.teamServices = teamServices;
    }

    @PostMapping()
    public ResponseEntity<Void> addTeam(@RequestBody RegisterTeamDto team) {
        try {
            teamServices.createTeam(team);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println("Error in TeamController.addTeam: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<QueryTeamsDto> getTeamByName(@RequestParam String name) {
        try {
            return ResponseEntity.ok(teamServices.getTeamByName(name));
        } catch (Exception e) {
            System.out.println("Error in TeamController.getTeamByName: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<QueryTeamsDto> getClubsByCountry(@PathVariable("country") String country) {
        try {
            QueryTeamsDto team = teamServices.getClubsByCountry(country);
            return ResponseEntity.ok(team);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }
}
