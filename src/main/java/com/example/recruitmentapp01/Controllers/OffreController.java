package com.example.recruitmentapp01.Controllers;

import com.example.recruitmentapp01.Entities.Offre;
import com.example.recruitmentapp01.Services.OffreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offre")
public class OffreController {

    @Autowired
    private OffreServices offreServices;

    @GetMapping("/getAll")
    public ResponseEntity<List<Offre>> getAllOffres() {
        List<Offre> offres = offreServices.getAllOffre();
        if (offres.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(offres, HttpStatus.OK);
        }
    }

    @GetMapping("/filterByEntreprise/{entreprise}")
    public ResponseEntity<List<Offre>> getOffreByEntreprise(@PathVariable String entreprise) {
        List<Offre> offres = offreServices.getOffreByEntreprise(entreprise);
        if (offres.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(offres, HttpStatus.OK);
        }
    }

    @GetMapping("/filterBySalaire/{salaire}")
    public ResponseEntity<List<Offre>> getOffreBySalaire(@PathVariable double salaire) {
        List<Offre> offres = offreServices.getOffreBySalaire(salaire);
        if (offres.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(offres, HttpStatus.OK);
        }
    }

    @GetMapping("/filterByTitre/{titre}")
    public ResponseEntity<List<Offre>> getOffreByTitre(@PathVariable String titre) {
        List<Offre> offres = offreServices.getOffreByTitre(titre);
        if (offres.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(offres, HttpStatus.OK);
        }
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Offre> getOffreById(@PathVariable Long id) {
        Offre offre = offreServices.getOffreById(id);
        if (offre != null) {
            return new ResponseEntity<>(offre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/newoffre")
    public ResponseEntity<Offre> createOffre(@RequestBody Offre offre) {
        Offre createdOffre = offreServices.createOffre(offre);
        return new ResponseEntity<>(createdOffre, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOffre(@PathVariable("id") Long id) {
        offreServices.deleteOffre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Offre> updateOffre(@PathVariable Long id, @RequestBody Offre offre) {
        Offre updatedOffre = offreServices.updateOffre(id, offre);
        if (updatedOffre != null) {
            return new ResponseEntity<>(updatedOffre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
