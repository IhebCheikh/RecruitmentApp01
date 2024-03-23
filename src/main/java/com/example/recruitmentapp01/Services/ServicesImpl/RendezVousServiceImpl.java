package com.example.recruitmentapp01.Services.ServicesImpl;

import com.example.recruitmentapp01.Entities.RendezVous;
import com.example.recruitmentapp01.Repositories.RendezVousRepo;
import com.example.recruitmentapp01.Services.RendezVousServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousServiceImpl implements RendezVousServices {

    @Autowired
    private RendezVousRepo rendezVousRepo;

    @Override
    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepo.findAll();
    }

    @Override
    public RendezVous getRendezVousById(Long id) {
        return rendezVousRepo.findById(id).orElse(null);
    }

    @Override
    public RendezVous createRendezVous(RendezVous rendezVous) {
        return rendezVousRepo.save(rendezVous);
    }

    @Override
    public RendezVous updateRendezVous(Long id, RendezVous rendezVous) {
        RendezVous existingRendezVous = rendezVousRepo.findById(id).orElse(null);
        if (existingRendezVous != null) {
            existingRendezVous.setLocalisation(rendezVous.getLocalisation());
            existingRendezVous.setDate(rendezVous.getDate());
            existingRendezVous.setCandidature(rendezVous.getCandidature());
            return rendezVousRepo.save(existingRendezVous);
        } else {
            return null;
        }
    }

    @Override
    public void deleteRendezVous(Long id) {
        rendezVousRepo.deleteById(id);
    }
}
