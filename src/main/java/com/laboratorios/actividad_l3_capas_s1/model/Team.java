package com.laboratorios.actividad_l3_capas_s1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@Entity
@Table(schema = "labo3", name = "TEAM")
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "COACH", nullable = false)
    private String coach;

    @Column(name = "TITLES", nullable = false)
    private int titles;
}
