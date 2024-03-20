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
@CrossOrigin("*")
public class OffreController {

@Autowired
    private OffreServices offreServices;

@GetMapping("/getAll")
    public ResponseEntity<List<Offre>> getAllOffres(){
//
//    try {
//        List<Offre> offres = offreServices.getAllOffre();
//        if (offres.isEmpty()) {
//            return new ResponseEntity<List<Offre>>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<List<Offre>>(offres, HttpStatus.OK);
//        }
//    }catch (Exception e){
//        return new ResponseEntity<List<Offre>>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
     return (ResponseEntity<List<Offre>>) offreServices.getAllOffre();
}


    @GetMapping("/filterByEntreprise/{entreprise}")
    public ResponseEntity <List<Offre>> getOffreByEntreprise(@PathVariable String entreprise){

            return ResponseEntity.ok(this.offreServices.getOffreByEntreprise(entreprise));
    }

    @GetMapping("/filterBySalaire/{salaire}")
public ResponseEntity<List<Offre>>getOffreBySalaire(@PathVariable double salaire){

    return ResponseEntity.ok(this.offreServices.getOffreBySalaire(salaire));
    }

    @GetMapping("/filterByTitre/{titre}")
    public ResponseEntity<List<Offre>>getOffreByTitre(@PathVariable String titre){
    return ResponseEntity.ok(this.offreServices.getOffreByTitre(titre));
    }

    @GetMapping("/getbyid/{id}")
    public  Offre getOffreById(@PathVariable Long id){
    return offreServices.getOffreById(id);
    }

    @PostMapping("/newoffre")
    public Offre createOffre(@RequestBody Offre offre){

    return offreServices.createOffre(offre);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOffre(@PathVariable("id") Long id){
    offreServices.deleteOffre(id);
    }

}
