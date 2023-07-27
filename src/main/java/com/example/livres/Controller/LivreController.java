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

import com.example.livres.Entity.Livre;
import com.example.livres.Service.AnnuaireLivre;

@RestController
public class LivreController {

    @Autowired
    AnnuaireLivre annuaire;

    @GetMapping("livres")
    public List<Livre> getLivres() {

        return annuaire.getAllLivres();
    }

    @PostMapping("livres")
    public ResponseEntity<Livre> savLivre(@RequestBody Livre newLivre) {
        System.out.println(newLivre);

        Livre livreCree = annuaire.addLivre(newLivre);

        return ResponseEntity.ok(livreCree);

    }

    @DeleteMapping("livres/{id}")
    public ResponseEntity<String> deleteByLivre(@PathVariable("id") Integer id) {
        Optional<Livre> optional = annuaire.getLivre(id);

        if (optional.isPresent()) {
            annuaire.deleteLivre(id);
            return ResponseEntity.ok("livre avec id : " + id + " est supprimé");

        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("livres/{id}")
    public ResponseEntity<Livre> putLivre(@PathVariable("id") Integer id, @RequestBody Livre livre) {
        Optional<Livre> optional = annuaire.getLivre(id);

        if (!id.equals(livre.getId())) {
            return ResponseEntity.badRequest().build();

        }

        if (optional.isPresent()) {

            annuaire.editLivre(id, livre);
            return ResponseEntity.ok(optional.get());

        }

        return ResponseEntity.notFound().build();

    }

}
