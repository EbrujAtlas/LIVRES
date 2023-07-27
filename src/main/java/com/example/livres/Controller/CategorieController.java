package com.example.livres.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.livres.Entity.Categorie;
import com.example.livres.Service.AnnuaireCategorie;

@RestController
public class CategorieController {

    @Autowired
    AnnuaireCategorie annuaire;

    @GetMapping("categories")
    public List<Categorie> getCategories() {

        return annuaire.getAllCategories();
    }

    @PostMapping("categories")
    public ResponseEntity<Categorie> savCategorie(@RequestBody Categorie newCategorie) {
        System.out.println(newCategorie);

        Categorie categorieCree = annuaire.addCategorie(newCategorie);

        return ResponseEntity.ok(categorieCree);

    }

    @DeleteMapping("categories/{id}")
    public ResponseEntity<String> deleteByCategorie(@PathVariable("id") Integer id) {
        Optional<Categorie> optional = annuaire.getCategorie(id);

        if (optional.isPresent()) {
            annuaire.deleteCategorie(id);
            return ResponseEntity.ok("categorie avec id : " + id + " est supprimé");

        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("categories/{id}")
    public ResponseEntity<Categorie> putCategorie(@PathVariable("id") Integer id, @RequestBody Categorie categorie) {
        Optional<Categorie> optional = annuaire.getCategorie(id);

        if (!id.equals(categorie.getId())) {
            return ResponseEntity.badRequest().build();

        }

        if (optional.isPresent()) {

            annuaire.editCategorie(id, categorie);
            return ResponseEntity.ok(optional.get());

        }

        return ResponseEntity.notFound().build();

    }

}
