package com.example.recruitmentapp01.Controllers;

import com.example.recruitmentapp01.Entities.Cv;
import com.example.recruitmentapp01.Services.CvServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cv")
public class CvController {

    @Autowired
    private CvServices cvService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Cv>> getAllCvs() {
        List<Cv> cvs = cvService.getAllCvs();
        if (cvs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(cvs, HttpStatus.OK);
        }
    }

    @GetMapping("/filterByDomaine/{domaine}")
    public ResponseEntity<List<Cv>> getCvsByDomaine(@PathVariable String domaine) {
        List<Cv> cvs = cvService.getCvsByDomaine(domaine);
        if (cvs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cvs, HttpStatus.OK);
        }
    }

    @GetMapping("/filterByExperience/{experience}")
    public ResponseEntity<List<Cv>> getCvsByExperience(@PathVariable int experience) {
        List<Cv> cvs = cvService.getCvsByExperience(experience);
        if (cvs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cvs, HttpStatus.OK);
        }
    }

    @GetMapping("/filterByAdresse/{adresse}")
    public ResponseEntity<List<Cv>> getCvsByAdresse(@PathVariable String adresse) {
        List<Cv> cvs = cvService.getCvsByAdresse(adresse);
        if (cvs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cvs, HttpStatus.OK);
        }
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Cv> getCvById(@PathVariable Long id) {
        Cv cv = cvService.getCvById(id);
        if (cv != null) {
            return new ResponseEntity<>(cv, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/newcv")
    public ResponseEntity<Cv> createCv(@RequestBody Cv cv) {
        Cv createdCv = cvService.createCv(cv);
        return new ResponseEntity<>(createdCv, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCv(@PathVariable("id") Long id) {
        cvService.deleteCv(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cv> updateCv(@PathVariable Long id, @RequestBody Cv cv) {
        Cv updatedCv = cvService.updateCv(id, cv);
        if (updatedCv != null) {
            return new ResponseEntity<>(updatedCv, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
