/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models;
/**
 *
 * @author ASUS
 */
public class Plat {
    
     public int id;
    public String nom;
    public Double note;
public double prix ;
public String details ;
    public Plat() {
    }

    public Plat(int id, String nom, Double note, Double prix,String details) {
        this.id = id;
        this.nom = nom;
       
        this.note = note;
        this.details=details;
        this.prix=prix ;
       
    }
    
    
        public Plat(int id, String nom, Double note,String details) {
        this.id = id;
        this.nom = nom;
       
        this.note = note;
        this.details=details;
       
    }
        public Plat( String nom, Double note, Double prix,String details) {
        this.nom = nom;
       
        this.note = note;
        this.details=details;
        this.prix=prix ;
       
    }
        
        
            public Plat (String  nom, Double note) {
       
        this.nom = nom;
       
        this.note = note;
      
    }
    
      

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   
    public Double getNote() {
        return note;
    }

    public void setVote(Double vote) {
        this.note = note;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    



    
}
