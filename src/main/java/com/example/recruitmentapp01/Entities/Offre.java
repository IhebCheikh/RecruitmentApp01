package com.example.recruitmentapp01.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private  String description;

    private String entreprise;

    private double salaire;

    @ManyToOne
    @JoinColumn(name = "recruteur_id")
    private User recruteur;

//    @ManyToMany
//    @JoinTable(name = "offre_candidat",
//            joinColumns = @JoinColumn(name = "offre_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private List<User> candidats;

    @OneToMany(mappedBy = "offre")
    private List<Candidature> candidatures;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
