package com.example.recruitmentapp01.Services.ServicesImpl;

import com.example.recruitmentapp01.Entities.Cv;
import com.example.recruitmentapp01.Entities.Offre;
import com.example.recruitmentapp01.Repositories.CvRepo;
import com.example.recruitmentapp01.Repositories.OffreRepo;
import com.example.recruitmentapp01.Services.CvServices;
import com.example.recruitmentapp01.Services.OffreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CvServiceImpl implements CvServices {

    @Autowired
    private CvRepo cvRepository;

    @Override
    public List<Cv> getAllCvs() {
        return cvRepository.findAll();
    }

    @Override
    public List<Cv> getCvsByDomaine(String domaine) {
        return cvRepository.findByDomaine(domaine);
    }

    @Override
    public List<Cv> getCvsByExperience(int experience) {
        return cvRepository.findByExperience(experience);
    }

    @Override
    public List<Cv> getCvsByAdresse(String adresse) {
        return cvRepository.findByAdresse(adresse);
    }


    @Override
    public Cv getCvById(Long id) {
        return cvRepository.findById(id).orElse(null);
    }

    @Override
    public Cv createCv(Cv cv) {
        return cvRepository.save(cv);
    }

    @Override
    public Cv updateCv(Long id, Cv cv) {
        Cv existingCv = cvRepository.findById(id).orElse(null);
        if (existingCv != null) {
            // Mettre à jour les champs du CV existant avec les nouvelles données
            existingCv.setId(cv.getId());
            // Mettre à jour d'autres champs selon vos besoins
            //existingCv.s(cv.getChamp2());

            // Enregistrer les modifications dans la base de données
            return cvRepository.save(existingCv);
        } else {
            return null; // Ou lancer une exception appropriée si nécessaire
        }
    }

    @Override
    public void deleteCv(Long id) {
        cvRepository.deleteById(id);
    }
}
