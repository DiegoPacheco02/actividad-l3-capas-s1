package com.laboratorios.actividad_l3_capas_s1.controllers;

import com.laboratorios.actividad_l3_capas_s1.dto.QueryTeamsDto;
import com.laboratorios.actividad_l3_capas_s1.services.TeamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.laboratorios.actividad_l3_capas_s1.dto.RegisterTeamDto;
import com.laboratorios.actividad_l3_capas_s1.services.TeamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clubs")
public class TeamController {

    @Autowired
    private final TeamServices teamServices;

    public TeamController(TeamServices teamServices) {
        this.teamServices = teamServices;
    }

    @PostMapping()
    public ResponseEntity<Void> addTeam(@RequestBody  RegisterTeamDto team) {
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
}
