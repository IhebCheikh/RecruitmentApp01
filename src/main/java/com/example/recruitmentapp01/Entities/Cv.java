package com.example.recruitmentapp01.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cv;
    private String adresse;
    private String domaine;
    private int experience;


    @ManyToOne
    @JoinColumn(name = "candidature_id")
    private Candidature candidature;
}
