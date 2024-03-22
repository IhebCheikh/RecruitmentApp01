package com.example.recruitmentapp01.Services;

import com.example.recruitmentapp01.Entities.Cv;
import com.example.recruitmentapp01.Entities.Offre;

import java.util.List;
public interface CvServices {

    List<Cv> getAllCvs();
    List<Cv> getCvsByDomaine(String domaine);
    List<Cv> getCvsByExperience(int experience);
    List<Cv> getCvsByAdresse(String adresse);

    Cv getCvById(Long id);
    Cv createCv(Cv cv);
    Cv updateCv(Long id, Cv cv);
    void deleteCv(Long id);
}
