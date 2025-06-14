package com.laboratorios.actividad_l3_capas_s1.controllers;

import com.laboratorios.actividad_l3_capas_s1.services.TeamServices;
import org.springframework.beans.factory.annotation.Autowired;
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
}
