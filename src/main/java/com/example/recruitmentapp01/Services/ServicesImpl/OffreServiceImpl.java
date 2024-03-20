package com.example.recruitmentapp01.Services.ServicesImpl;

import com.example.recruitmentapp01.Entities.Offre;
import com.example.recruitmentapp01.Repositories.OffreRepo;
import com.example.recruitmentapp01.Services.OffreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OffreServiceImpl implements OffreServices {

    @Autowired
    private OffreRepo offreRepo;

    @Override
    public List<Offre> getAllOffre() {
        return this.offreRepo.findAll();
    }

    @Override
    public List<Offre> getOffreByEntreprise(String entreprise) {
        return this.offreRepo.getOffreByEntreprise(entreprise);
    }

    @Override
    public List<Offre> getOffreByTitre(String titre) {
        return this.offreRepo.getOffreByTitre(titre);
    }

    @Override
    public List<Offre> getOffreBySalaire(double salaire) {
        return this.offreRepo.getOffreBySalaire(salaire);
    }

    @Override
    public Offre getOffreById(Long id) {
        return this.offreRepo.findById(id).get();
    }

    @Override
    public Offre createOffre(Offre offre) {
        return this.offreRepo.save(offre);
    }

    @Override
    public Offre updateOffre(Offre offre) {
        return this.offreRepo.saveAndFlush(offre);
    }

    @Override
    public void deleteOffre(Long id) {
        offreRepo.deleteById(id);
    }
}
