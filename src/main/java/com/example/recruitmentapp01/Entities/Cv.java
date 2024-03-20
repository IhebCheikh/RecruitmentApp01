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



    @ManyToOne
    @JoinColumn(name = "candidature_id")
    private Candidature candidature;
}
