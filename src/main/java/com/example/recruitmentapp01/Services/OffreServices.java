package com.example.recruitmentapp01.Services;

import com.example.recruitmentapp01.Entities.Offre;

import java.util.List;

public interface OffreServices {

    public List<Offre>getAllOffre();
    public List<Offre>getOffreByEntreprise(String entreprise);
    public List<Offre>getOffreByTitre(String titre);

    public List<Offre>getOffreBySalaire(double salaire);

    Offre getOffreById(Long id);
    Offre createOffre(Offre offre);

    Offre updateOffre(Long id, Offre offre);
    public void deleteOffre(Long id);

}
