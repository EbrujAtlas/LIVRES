package com.example.livres.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.livres.Dao.AuteurRepo;
import com.example.livres.Entity.Auteur;

@Service
public class AnnuaireAuteur {

    @Autowired
    AuteurRepo auteurRepo;

    public Auteur addAuteur(Auteur auteur) {
        return auteurRepo.save(auteur);

    }

    public List<Auteur> getAllAuteurs() {
        return auteurRepo.findAll();
    }

    public void deleteAuteur(Integer id) {
        auteurRepo.deleteById(id);
    }

    public Optional<Auteur> getAuteur(Integer id) {

        return auteurRepo.findById(id);

    }

    public void editAuteur(Integer id, Auteur auteur) {
        auteurRepo.save(auteur);

    }

}
