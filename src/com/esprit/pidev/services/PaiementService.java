/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.esprit.pidev.models.AbonneResto;
import com.esprit.pidev.utils.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.esprit.pidev.models.Paiement;
/**
 *
 * @author ASUS
 */
public class PaiementService {
    
     private ConnectionRequest request;

    private boolean responseResult;
    public ArrayList<Paiement> paiements;


    public PaiementService() {
        request = DataSource.getInstance().getRequest();
    }
    
    
    
     public boolean addPaiement(Paiement p) {
       // String url = "http://localhost/pi/web/app_dev.php/babysitter/AjouterMobile?&date_dispoS=" + "/abonne/" + 1+ "/"+ abonne.getNom()+ "/" +abonne.getTypeAbo()+ "/" +abonne.getTypePension()+ "/" +0+ "/" +0 ;
        String url = "http://localhost/devitt2/devitt2/web/app_dev.php/resto/paiement/newMobile?&idC=" + p.getIdC()+ "&type=" + p.getType()+ "&total=" + p.getTotal();

        request.setUrl(url);

        request.addResponseListener((e) -> {
            String str = new String(request.getResponseData());
            System.out.println(str);


        });         
             
     NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }
     
     
  
      
     
     public ArrayList<Paiement> parseTasks(String jsonText) {
        try {
            paiements = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> tasksListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                int id = (int)Float.parseFloat(obj.get("id").toString());
                int idC = (int)Float.parseFloat(obj.get("idC").toString());

                int total = (int)Float.parseFloat(obj.get("total").toString());
                String type = obj.get("type").toString();
              String date = obj.get("date").toString();

               
                                
                paiements.add(new Paiement(id,idC, type, total,date));
            }

        } catch (IOException ex) {
        }

        return paiements;
    }
     
     
     
     
     
     
     
     
     
           ArrayList<AbonneResto> listReservation = new ArrayList<>();

     
      public ArrayList<Paiement> getList(){       

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/devitt2/devitt2/web/app_dev.php/resto/paiement/AfficherMobile");  

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                paiements = parseTasks(new String(con.getResponseData()));

                   System.out.println("kkkkk");
                                      System.out.println(paiements);

             con.removeResponseListener(this);

                }
            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return paiements;
    }
    
    
      
      
   /*   public ArrayList<AbonneResto> rechercher(String x) {
        ConnectionRequest req = new ConnectionRequest();

        req.setUrl("http://localhost/devitt2/devitt2/web/app_dev.php/resto/abonneresto/RechercherMobile/"+x
                +"");
    
         
        
         req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                abonnes = parseTasks(new String(req.getResponseData()));

                   System.out.println("kkkkk");
                                      System.out.println(abonnes);

             req.removeResponseListener(this);

                }
            
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return abonnes;

      
    }*/
      
      
    
}
