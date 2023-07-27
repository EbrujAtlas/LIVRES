package com.example.livres.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.livres.Dao.LivreRepo;
import com.example.livres.Entity.Livre;

@Service
public class AnnuaireLivre {

    @Autowired
    LivreRepo livreRepo;

    public Livre addLivre(Livre livre) {
        return livreRepo.save(livre);

    }

    public List<Livre> getAllLivres() {
        return livreRepo.findAll();
    }

    public void deleteLivre(Integer id) {
        livreRepo.deleteById(id);
    }

    public Optional<Livre> getLivre(Integer id) {

        return livreRepo.findById(id);

    }

    public void editLivre(Integer id, Livre livre) {
        livreRepo.save(livre);

    }

}
