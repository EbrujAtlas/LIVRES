package com.example.livres.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String roman;

    private String scienceFicton;

    private String bd;

    public Categorie() {
    }

    public Categorie(String roman, String scienceFicton, String bd) {
        this.roman = roman;
        this.scienceFicton = scienceFicton;
        this.bd = bd;
    }

    public Integer getId() {
        return id;
    }

    public String getRoman() {
        return roman;
    }

    public String getScienceFicton() {
        return scienceFicton;
    }

    public String getBd() {
        return bd;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRoman(String roman) {
        this.roman = roman;
    }

    public void setScienceFicton(String scienceFicton) {
        this.scienceFicton = scienceFicton;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

}
