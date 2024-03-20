package com.example.recruitmentapp01.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String adresse;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String mail;


    @OneToMany(mappedBy = "recruteur")
    private List<Offre> recruteur;
//
//    @ManyToMany(mappedBy = "candidat")
//    private List<Offre> candidats;

    @OneToMany(mappedBy = "candidat")
    private List<Candidature> candidatures;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
