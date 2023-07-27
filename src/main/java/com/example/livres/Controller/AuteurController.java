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

import com.example.livres.Entity.Auteur;
import com.example.livres.Service.AnnuaireAuteur;

@RestController
public class AuteurController {

    @Autowired
    AnnuaireAuteur annuaire;

    @GetMapping("auteurs")
    public List<Auteur> getAuteurs() {

        return annuaire.getAllAuteurs();
    }

    @PostMapping("auteurs")
    public ResponseEntity<Auteur> savAuteur(@RequestBody Auteur newAuteur) {
        System.out.println(newAuteur);

        Auteur auteurCree = annuaire.addAuteur(newAuteur);

        return ResponseEntity.ok(auteurCree);

    }

    @DeleteMapping("auteurs/{id}")
    public ResponseEntity<String> deleteByAuteur(@PathVariable("id") Integer id) {
        Optional<Auteur> optional = annuaire.getAuteur(id);

        if (optional.isPresent()) {
            annuaire.deleteAuteur(id);
            return ResponseEntity.ok("auteur avec id : " + id + " est supprimé");

        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("auteurs/{id}")
    public ResponseEntity<Auteur> putAuteur(@PathVariable("id") Integer id, @RequestBody Auteur auteur) {
        Optional<Auteur> optional = annuaire.getAuteur(id);

        if (!id.equals(auteur.getId())) {
            return ResponseEntity.badRequest().build();

        }

        if (optional.isPresent()) {

            annuaire.editAuteur(id, auteur);
            return ResponseEntity.ok(optional.get());

        }

        return ResponseEntity.notFound().build();

    }

}
