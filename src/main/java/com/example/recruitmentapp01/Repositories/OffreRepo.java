package com.example.recruitmentapp01.Repositories;

import com.example.recruitmentapp01.Entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffreRepo extends JpaRepository<Offre,Long> {

    public List<Offre>getOffreByEntreprise(String entreprise);

    public List<Offre>getOffreByTitre(String titre);

    public List<Offre>getOffreBySalaire(double salaire);


}
