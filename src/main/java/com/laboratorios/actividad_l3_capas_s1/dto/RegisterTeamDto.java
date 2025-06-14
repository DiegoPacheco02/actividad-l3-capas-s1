package com.laboratorios.actividad_l3_capas_s1.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterTeamDto {
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Country cannot be null")
    @NotEmpty(message = "Country cannot be empty")
    private String country;

    @NotNull(message = "Coach cannot be null")
    @NotEmpty(message = "Coach cannot be empty")
    private String coach;

    @NotNull(message = "Titles cannot be null")
    @Min(value = 0, message = "Titles must be a non-negative integer")
    private int titles;
}