package com.example.recruitmentapp01.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cv;
    private String adresse;
    private String domaine;
    private int experience;

    // added set & get for updating cv
    public void setId(Long id) {
        this.id = id;
    }

    // added set & get for updating cv
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "candidature_id")
    private Candidature candidature;
}
