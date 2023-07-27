package com.example.livres.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.livres.Dao.CategorieRepo;
import com.example.livres.Entity.Categorie;

@Service
public class AnnuaireCategorie {

    @Autowired
    CategorieRepo categorieRepo;

    public Categorie addCategorie(Categorie categorie) {
        return categorieRepo.save(categorie);

    }

    public List<Categorie> getAllCategories() {
        return categorieRepo.findAll();
    }

    public void deleteCategorie(Integer id) {
        categorieRepo.deleteById(id);
    }

    public Optional<Categorie> getCategorie(Integer id) {

        return categorieRepo.findById(id);

    }

    public void editCategorie(Integer id, Categorie categorie) {
        categorieRepo.save(categorie);

    }

}
