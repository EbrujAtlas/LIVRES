package com.example.livres.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.livres.Entity.Livre;

@Repository
public interface LivreRepo extends JpaRepository<Livre, Integer> {

}
