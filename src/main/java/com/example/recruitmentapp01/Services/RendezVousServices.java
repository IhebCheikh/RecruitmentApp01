package com.example.recruitmentapp01.Services;

import com.example.recruitmentapp01.Entities.RendezVous;

import java.util.List;

public interface RendezVousServices {

    List<RendezVous> getAllRendezVous();
    RendezVous getRendezVousById(Long id);
    RendezVous createRendezVous(RendezVous rendezVous);
    RendezVous updateRendezVous(Long id, RendezVous rendezVous);
    void deleteRendezVous(Long id);
}
