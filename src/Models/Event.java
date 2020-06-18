/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;



import com.codename1.util.DateUtil;
import java.util.Date;














/**
 *
 * @author asus
 */
public class Event {
    private int id,nbrPlaceDispo;
    private String nomEvent,categorieEvent,description,adresse;
    private Date dateEvent;

    public Event(int id, String nomEvent, String categorieEvent, int nbrPlaceDispo, Date dateEvent, String description, String adresse) {
        this.id = id;
        this.nbrPlaceDispo = nbrPlaceDispo;
        this.nomEvent = nomEvent;
        this.categorieEvent = categorieEvent;
        this.description = description;
       this.dateEvent = dateEvent;
       this.adresse = adresse;
    }
     public Event(String nomEvent, String categorieEvent, int nbrPlaceDispo, Date dateEvent, String description, String adresse) {
       // this.id = id;
        this.nbrPlaceDispo = nbrPlaceDispo;
        this.nomEvent = nomEvent;
        this.categorieEvent = categorieEvent;
        this.description = description;
       this.dateEvent = dateEvent;
       this.adresse = adresse;
    }

    public Event(int id, String nomEvent, String categorieEvent, int nbrPlaceDispo, String description, Date dateEvent, String adresse) {
        this.id = id;
        this.nbrPlaceDispo = nbrPlaceDispo;
        this.nomEvent = nomEvent;
        this.categorieEvent = categorieEvent;
        this.description = description;
        this.adresse = adresse;
        this.dateEvent = dateEvent;
    }
     
        public Event(String nomEvent, String categorieEvent, int nbrPlaceDispo,  String description, String adresse) {
       // this.id = id;
        this.nbrPlaceDispo = nbrPlaceDispo;
        this.nomEvent = nomEvent;
        this.categorieEvent = categorieEvent;
        this.description = description;
       //this.dateEvent = dateEvent;
       this.adresse = adresse;
    }
      public Event( String nomEvent, String categorieEvent, int nbrPlaceDispo, Date dateEvent, String description) {
        
        this.nbrPlaceDispo = nbrPlaceDispo;
        this.nomEvent = nomEvent;
        this.categorieEvent = categorieEvent;
        this.description = description;
        this.dateEvent = dateEvent;
    }
        public Event(int id, String nomEvent, String categorieEvent, int nbrPlaceDispo, String description) {
        this.id = id;
        this.nbrPlaceDispo = nbrPlaceDispo;
        this.nomEvent = nomEvent;
        this.categorieEvent = categorieEvent;
        this.description = description;
       
    }
            public Event( String nomEvent, String categorieEvent, int nbrPlaceDispo, String description) {
        
        this.nbrPlaceDispo = nbrPlaceDispo;
        this.nomEvent = nomEvent;
        this.categorieEvent = categorieEvent;
        this.description = description;
       
    }

      public Event(int id,String nomEvent, String categorieEvent, int nbrPlaceDispo,  String description, String adresse) {
        this.id = id;
        this.nbrPlaceDispo = nbrPlaceDispo;
        this.nomEvent = nomEvent;
        this.categorieEvent = categorieEvent;
        this.description = description;
       //this.dateEvent = dateEvent;
       this.adresse = adresse;
    }

    public Event() {
        
    }

   

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbrPlaceDispo() {
        return nbrPlaceDispo;
    }

    public void setNbrPlaceDispo(int nbrPlaceDispo) {
        this.nbrPlaceDispo = nbrPlaceDispo;
    }

    public String getNomEvent() {
        return nomEvent;
    }

    public void setNomEvent(String nomEvent) {
        this.nomEvent = nomEvent;
    }

    public String getCategorieEvent() {
        return categorieEvent;
    }

    public void setCategorieEvent(String categorieEvent) {
        this.categorieEvent = categorieEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }
    
}
