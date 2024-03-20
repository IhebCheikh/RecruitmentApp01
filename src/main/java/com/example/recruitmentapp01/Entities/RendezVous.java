package com.example.recruitmentapp01.Entities;

import jakarta.persistence.*;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

private String localisation;
private DateTimeLiteralExpression.DateTime date;

    @OneToOne
    @JoinColumn(name = "candidature_id", unique = true)
    private Candidature candidature;


}
