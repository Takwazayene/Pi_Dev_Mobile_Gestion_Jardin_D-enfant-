/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Paiement {
     private int idP;
  private int idC;
  private String type ;
  private float total ;
  private String date ;

    public Paiement() {
    }

    public Paiement(int idP, int idC, String type, float total, String date) {
        this.idP = idP;
        this.idC = idC;
        this.type = type;
        this.total = total;
        this.date=date;
    }
    
    
    public Paiement(int idP, int idC, String type, float total) {
        this.idP = idP;
        this.idC = idC;
        this.type = type;
        this.total = total;
    }
    
       public Paiement( int idC, String type, float total,String date) {
       
        this.idC = idC;
        this.type = type;
        this.total = total;
        this.date=date;
    }
       
         public Paiement( int idC, String type, float total) {
       
        this.idC = idC;
        this.type = type;
        this.total = total;
        
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
  
  
  
  
    
    
}
