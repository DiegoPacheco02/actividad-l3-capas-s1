package com.laboratorios.actividad_l3_capas_s1.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class RegisterTeamDto {
    @NotNull
    private String name;
    @NotNull
    private String country ;
    @NotNull
    private String coach ;
    @NotNull
    private int titles;


}