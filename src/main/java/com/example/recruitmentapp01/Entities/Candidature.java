package com.example.recruitmentapp01.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@Enumerated(EnumType.STRING)
@Column(name = "statut")
    private Statut statut;

    private double note;

    @OneToOne(mappedBy = "candidature")
    private RendezVous rendezVous;

    @OneToMany(mappedBy = "candidature", cascade = CascadeType.ALL)
    private List<Cv> cvs;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User candidat;

    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
