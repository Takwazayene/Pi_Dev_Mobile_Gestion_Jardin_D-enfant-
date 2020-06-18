/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Club;
import Utils.DataSource;
import Utils.Statics;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.components.ToastBar;
import com.codename1.facebook.Post;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Calendar;
import com.codename1.ui.Display;
import static com.codename1.ui.events.ActionEvent.Type.Response;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.codename1.util.Base64;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author aissa
 */
public class TaskService {

    private ConnectionRequest request;
     public static TaskService instance=null;
    //private ConnectionRequest con;

    private boolean responseResult;
    public ArrayList<Club> clubs;
    

    public static TaskService getInstance() {
        
        if (instance == null) {
            instance = new TaskService();
        }
        return instance;
    }
    public TaskService() {
        
        request = DataSource.getInstance().getRequest();
    }

    public boolean addTask(Club c) {
        String url = Statics.BASE_URL + "/club/Ajout?NomClub=" + c.getNomClub()+ "&ActiviteClub=" + c.getActiviteClub()+ "&Effectif=" + c.getEffectif();

        
        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
                
     
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(request);
      
     
 
        
        return responseResult;
        

    
      
        
    }
    
    
    

    public ArrayList<Club> getAllTasks() {
        String url = Statics.BASE_URL + "/club/clubs/all";

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                clubs = parseTasks(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
       

        NetworkManager.getInstance().addToQueueAndWait(request);

        return clubs;
    }

    public ArrayList<Club> parseTasks(String jsonText) {
        try {
            clubs = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> tasksListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                int id = (int)Float.parseFloat(obj.get("id").toString());
                String name = obj.get("nomClub").toString();
                String act = obj.get("activiteClub").toString();
                int eff = (int)Float.parseFloat(obj.get("effectif").toString());
                clubs.add(new Club(id, name, act, eff));
            }

        } catch (IOException ex) {
        }

        return clubs;
      
    }
   // public boolean ParticiperClub(Club club){
    //public ArrayList<Club> ParticiperClub() {
    public boolean ParticiperClub(Club club) {
   // public boolean ParticiperClub(Club c){

          String url =  Statics.BASE_URL + "/club/participer/" +club.getId();
          request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; //Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);
      
        return responseResult;
        
    }
    
    
     public boolean modifier(Club c) {
         
       String url = Statics.BASE_URL+"/club/updat/"+c.getId()+"?n=" +c.getNomClub()+"&d=" +c.getActiviteClub()+"&e=" +c.getEffectif();
   //    String url = Statics.BASE_URL +"/posts/update/"+e.getId()+"/"+e.getTitle()+"/"+e.getDescription()+"/"+e.getRating();
        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; //Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);
        return responseResult;
    }

  public boolean deletClub(Club c) {
        String url = Statics.BASE_URL + "/club/delet/"+c.getId();
        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; //Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);
       
        return responseResult;
    }
  
  
  public ArrayList<Club> rech(String re ){
       String url = Statics.BASE_URL + "/club/fin/" +re;
        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                clubs = parseTasks(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
         
        NetworkManager.getInstance().addToQueueAndWait(request);
      
        return clubs;
}
    
    
      
  
}