/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.codename1.charts.renderers.DefaultRenderer;

/**
 *
 * @author asus
 */
public class Club {
    private int id;
    private String nomClub;
    private String activiteClub;
    private int effectif;

    public Club(int id, String nomClub, String activiteClub, int effectif) {
        this.id = id;
        this.nomClub = nomClub;
        this.activiteClub = activiteClub;
        this.effectif = effectif;
    }
 
    
    public Club(String nomClub, String activiteClub) {
      //  this.id = id;
        this.nomClub = nomClub;
        this.activiteClub = activiteClub;
      // this.effectif = effectif;
    }

    public Club(String nomClub, String activiteClub, int effectif) {
        this.nomClub = nomClub;
        this.activiteClub = activiteClub;
        this.effectif = effectif;
    }

    public Club() {
        
    }

    

    public int getId() {
        return id;
    }

    public String getNomClub() {
        return nomClub;
    }

    public String getActiviteClub() {
        return activiteClub;
    }

    public int getEffectif() {
        return effectif;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    public void setActiviteClub(String activiteClub) {
        this.activiteClub = activiteClub;
    }

    public void setEffectif(int effectif) {
        this.effectif = effectif;
    }

    @Override
    public String toString() {
        return "Club{" + "id=" + id + ", nomClub=" + nomClub + ", activiteClub=" + activiteClub + ", effectif=" + effectif + '}';
    }

    
}
