package com.example.recruitmentapp01.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import com.example.recruitmentapp01.Entities.Cv;

import java.util.List;

public interface CvRepo extends JpaRepository<Cv, Long> {

    List<Cv> findByDomaine(String domaine);

    List<Cv> findByExperience(int experience);

    List<Cv> findByAdresse(String adresse);

    // Ajoutez d'autres méthodes de requête personnalisées si nécessaire
}
