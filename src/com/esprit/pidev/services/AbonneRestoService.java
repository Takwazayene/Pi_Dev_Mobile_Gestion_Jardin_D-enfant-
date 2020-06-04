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
import com.codename1.ui.util.Resources;
import com.esprit.pidev.models.AbonneResto;
import com.esprit.pidev.utils.DataSource;
import com.esprit.pidev.utils.Statics;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *
 * @author ASUS
 */
public class AbonneRestoService {
      private ConnectionRequest request;

    private boolean responseResult;
    public ArrayList<AbonneResto> abonnes;


    public AbonneRestoService() {
        request = DataSource.getInstance().getRequest();
    }
    
    
    
     public boolean addAbonne(AbonneResto abonne) {
       // String url = "http://localhost/pi/web/app_dev.php/babysitter/AjouterMobile?&date_dispoS=" + "/abonne/" + 1+ "/"+ abonne.getNom()+ "/" +abonne.getTypeAbo()+ "/" +abonne.getTypePension()+ "/" +0+ "/" +0 ;
        String url = "http://localhost/devitt2/devitt2/web/app_dev.php/resto/abonneresto/newMobile?&nom=" + abonne.getNom()+ "&typeAbo=" + abonne.getTypeAbo()+ "&typePension=" + abonne.getTypePension();

        request.setUrl(url);

        request.addResponseListener((e) -> {
            String str = new String(request.getResponseData());
            System.out.println(str);


        });         
             
     NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }
     
     
  
      
     
      public ArrayList<AbonneResto> parseTasks(String jsonText) {
        try {
            abonnes = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> tasksListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                int id = (int)Float.parseFloat(obj.get("id").toString());
                int idAb = (int)Float.parseFloat(obj.get("idAb").toString());

                int etat = (int)Float.parseFloat(obj.get("etat").toString());
                int absence = (int)Float.parseFloat(obj.get("absence").toString());
                String nom = obj.get("nom").toString();
                String typeAbo = obj.get("typeAbo").toString();
                String typePension = obj.get("typePension").toString();

                                
                abonnes.add(new AbonneResto(id,idAb, nom, typeAbo,typePension,etat,absence));
            }

        } catch (IOException ex) {
        }

        return abonnes;
    }
     
     
     
     
     
     
     
     
     
           ArrayList<AbonneResto> listReservation = new ArrayList<>();

     
      public ArrayList<AbonneResto> getList(){       

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/devitt2/devitt2/web/app_dev.php/resto/abonneresto/AfficherMobile");  

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                abonnes = parseTasks(new String(con.getResponseData()));

                   System.out.println("kkkkk");
                                      System.out.println(abonnes);

             con.removeResponseListener(this);

                }
            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return abonnes;
    }
    
    
      
      
      public ArrayList<AbonneResto> rechercher(String x) {
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

      
    }
      
      
      
}
