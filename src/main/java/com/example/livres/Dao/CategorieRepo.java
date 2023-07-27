package com.example.livres.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.livres.Entity.Categorie;

@Repository
public interface CategorieRepo extends JpaRepository<Categorie, Integer> {

}
