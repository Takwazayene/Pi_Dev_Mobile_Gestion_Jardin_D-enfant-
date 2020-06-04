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
import com.esprit.pidev.models.Plat;
import com.esprit.pidev.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.esprit.pidev.utils.DataSource;

/**
 *
 * @author ASUS
 */
public class PlatService {
     private ConnectionRequest request;

    private boolean responseResult;
    public ArrayList<Plat> plats;
    
    
      public PlatService() {
        request = DataSource.getInstance().getRequest();
    }
   
    public Map<String,Double> getListNote()
    {
    
        Map<String,Double> listArticles = new HashMap<>();
        ConnectionRequest con = new ConnectionRequest();
             con.setUrl("http://localhost/devitt2/devitt2/web/app_dev.php/resto/plats/AfficherMobile");  

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                try {
                    System.out.println((new String(con.getResponseData()).toCharArray())); 
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> note = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    List<Map<String, Object>> list =  (List<Map<String, Object>>) note.get("root");

                    for (Map<String, Object> obj : list) {
double vote = Double.parseDouble(obj.get("note").toString());                     
                       String s =   obj.get("nom").toString();
                    listArticles.put(s,vote);
                    }
                }catch (IOException ex) {
                    System.out.println("erreur parse");
                }
                }
               
            });
        

        NetworkManager.getInstance().addToQueueAndWait(con);
        return listArticles;
    }

    
    
    
     public ArrayList<Plat> getList() {
        String url ="http://localhost/devitt2/devitt2/web/app_dev.php/resto/plats/AfficherMobile";

       request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                plats = parseTasks(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return plats;
    }
    
     
       public ArrayList<Plat> parseTasks(String jsonText) {
        try {
            plats = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> tasksListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                int id = (int)Float.parseFloat(obj.get("id").toString());
                String nom = obj.get("nom").toString();
double note = Double.parseDouble(obj.get("note").toString());                     

                String details = obj.get("details").toString();

                plats.add(new Plat(id, nom, note,details));
            }

        } catch (IOException ex) {
        }

        return plats;
    }
    
    
}
