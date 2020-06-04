/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models;

import java.util.Date;
import com.codename1.ui.Image;
import com.codename1.ui.util.Resources;
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class AbonneResto {
      private int id ;
    private int idAb;
    private String nom;
    private  String typeAbo;
    private String typePension ;
    private int etat;
    private int absence;
    private Date dateAbo ;
    

    public AbonneResto() {
    }

    public AbonneResto(int idAb, String nom, String typeAbo,String typePension, int etat, int absence, Date dateAbo) {
        this.idAb = idAb;
        this.nom = nom;
        this.typeAbo = typeAbo;
        this.typePension=typePension;
        this.etat = etat;
        this.absence = absence;
        this.dateAbo = dateAbo;
    }
    
    
    
        public AbonneResto( String nom, String typeAbo,String typePension) {
        this.idAb = idAb;
        this.nom = nom;
        this.typeAbo = typeAbo;
        this.typePension=typePension;
        this.etat = etat;
        this.absence = absence;
        this.dateAbo = dateAbo;
    }
    
    
    
    
    

      
      
      public AbonneResto(int id ,int idAb, String nom, String typeAbo,String typePension, int etat, int absence) {
        this.id=id ;
        this.idAb = idAb;
        this.nom = nom;
        this.typeAbo = typeAbo;
        this.typePension=typePension;
        this.etat = etat;
        this.absence = absence;
    
    }
    
          public AbonneResto( int idAb, String nom, String typeAbo,String typePension, int etat, int absence) {
        this.idAb = idAb;
        this.nom = nom;
        this.typeAbo = typeAbo;
        this.typePension=typePension;
        this.etat = etat;
        this.absence = absence;
      
    }

      
           public AbonneResto( String nom, String typeAbo,String typePension, int absence,Date dateAbo) {
       
    
        this.nom = nom;
        this.typeAbo = typeAbo;
        this.typePension=typePension;
       
        this.absence = absence;
        this.dateAbo = dateAbo;
    }
           
  
         
         
          public AbonneResto(  String nom, String typeAbo,String typePension, int etat , int absence) {
          
        this.nom = nom;
        this.typeAbo = typeAbo;
        this.typePension=typePension;
       
        this.absence = absence;
        this.etat=etat;
        
    }

         
         
              public AbonneResto(  String nom, String typeAbo,String typePension,  int absence) {
          
        this.nom = nom;
        this.typeAbo = typeAbo;
        this.typePension=typePension;
       
        this.absence = absence;
        
 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
              
              
              
              

    public int getIdAb() {
        return idAb;
    }

    public void setIdAb(int idAb) {
        this.idAb = idAb;
    }
   

    public int getAbsence() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }

    public Date getDateAbo() {
        return dateAbo;
    }

    public void setDateAbo(Date dateAbo) {
        this.dateAbo = dateAbo;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getTypeAbo() {
        return typeAbo;
    }

    public void setTypeAbo(String typeAbo) {
        this.typeAbo = typeAbo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTypePension() {
        return typePension;
    }

    public void setTypePension(String typePension) {
        this.typePension = typePension;
    }

    @Override
    public String toString() {
        return "abonneResto{" + "id=" + id + ", idAb=" + idAb + ", nom=" + nom + "type abonnement=" + typeAbo + ", type pension=" + typePension + ", date abonnement=" + dateAbo +'}';
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
