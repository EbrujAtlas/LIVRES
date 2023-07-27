package com.example.livres.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.livres.Entity.Auteur;

@Repository
public interface AuteurRepo extends JpaRepository<Auteur, Integer> {

}
