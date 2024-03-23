package com.example.recruitmentapp01.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

@Entity
@Data
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String localisation;
    private DateTimeLiteralExpression.DateTime date;

    @OneToOne
    @JoinColumn(name = "candidature_id", unique = true)
    private Candidature candidature;


    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
