/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Club;
import Models.Event;
import static Services.TaskService.instance;
import Utils.DataSource;
import Utils.Statics;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.views.PieChart;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.L10NManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Calendar;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.util.DateUtil;



import java.io.IOException;







import java.util.ArrayList;
import java.util.Date;




import java.util.List;

import java.util.Map;

/**
 *
 * @author aissa
 */
public class TaskServiceE {

    private ConnectionRequest request;
 
    private ConnectionRequest con;

    private boolean responseResult;
    public ArrayList<Event> events;
public static TaskServiceE instance=null;
    
    
        public static TaskServiceE getInstance() {
        
        if (instance == null) {
            instance = new TaskServiceE();
        }
        return instance;
    }
    public TaskServiceE() {
        request = DataSource.getInstance().getRequest();
    }

    public boolean addTask(Event e) {
        String url = Statics.BASE_URL + "/event/events/Ajout?NomEvent=" + e.getNomEvent()+ "&CategorieEvent=" + e.getCategorieEvent()+ "&NbrPlaceDispo=" + e.getNbrPlaceDispo()+"&Description="+e.getDescription()+"&Adresse="+e.getAdresse();

        
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
    Picker datePicker = new Picker();
datePicker.setType(Display.PICKER_TYPE_DATE);
Picker dateTimePicker = new Picker();
dateTimePicker.setType(Display.PICKER_TYPE_DATE_AND_TIME);
Picker timePicker = new Picker();
timePicker.setType(Display.PICKER_TYPE_TIME);
Picker stringPicker = new Picker();
stringPicker.setType(Display.PICKER_TYPE_STRINGS);

datePicker.setDate(new Date());
dateTimePicker.setDate(new Date());



   
        
 
        return responseResult;
        

        
        
        
      
        
    }

    public ArrayList<Event> getAllTasks() {
        String url = Statics.BASE_URL + "/event/events/al";

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                events = parseTasks(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return events;
    }

    public ArrayList<Event> parseTasks(String jsonText) {
        try {
            events = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> tasksListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                int id = (int)Float.parseFloat(obj.get("id").toString());
                String nomEvent = obj.get("nomEvent").toString();
                String categorieEvent = obj.get("categorieEvent").toString();
                int nbrPlaceDispo = (int)Float.parseFloat(obj.get("nbrPlaceDispo").toString());
            
               String description = obj.get("description").toString();
        
  
              String adresse = obj.get("adresse").toString();
  
//Date startDate = (Date) format.parse((String);
             // String date=obj.get("vvv").new Date().toString();
               events.add(new Event(id, nomEvent, categorieEvent, nbrPlaceDispo,description , adresse));
            }

        } catch (IOException ex) {
        }

        return events;
      
    }
    
    

     
   
    
   // public boolean ParticiperClub(Club club){
    //public ArrayList<Club> ParticiperClub() {
      public boolean ParticiperEvent(Event event) {
   // public boolean ParticiperClub(Club c){

          String url =  Statics.BASE_URL + "/event/participa/" +event.getId();
         request.setUrl(url);
     //   request.setPost(false);
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
       
    }

 

