package com.laboratorios.actividad_l3_capas_s1.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class QueryTeamsDto {
    private UUID id;
    private String name;
    private String country;
    private String coach;
    private int titles;
}
