/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Models.Club;
import Models.Event;
import Services.TaskService;
import Services.TaskServiceE;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.TOP;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aissa
 */
public class TasksListFormE1 extends Form {
     EncodedImage imc;
    Image img;
    ImageViewer imv;
    public static String TITRE;
    public static String TITREimage;
    public static String TITREcontenue;
    public static String TITREDATE;
    ComboBox<String> cb1 = new ComboBox();

    public TasksListFormE1(Form previous) {
         EncodedImage imc;
        Image img;
        ImageViewer imv;
        
        setTitle("les events");
        //etToolbar().addCommandToLeftBar("back", null, e -> new WalkthruForm(res).show());
       // getToolbar().addCommandToRightBar("Reclamer", null, e -> new HomeReclamation(theme).show());
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
         Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label titre = new Label("Liste des events","WelcomeBlue");
         setLayout(new FlowLayout(CENTER,TOP));
               C1.add(titre);
               add(C1);
               
    
        TaskServiceE taskServiceE = new TaskServiceE();
        List<Event> events = taskServiceE.getAllTasks();
        if (events!= null && !events.isEmpty()) {
            for (Event event : events) {
                 int IdE=event.getId();
                Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
  Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
 Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
               Container C7 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
               Container C8 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              
               
                Font font = titre.getUnselectedStyle().getFont();
                Font newFont = Font.createSystemFont(font.getFace(), Font.STYLE_BOLD, font.getSize());
                titre.getUnselectedStyle().setFont(newFont);
                SpanLabel nomclub= new SpanLabel("Nom Event:   " + event.getNomEvent());
                SpanLabel cat = new SpanLabel("Categorie:   " + event.getCategorieEvent());
                SpanLabel branche = new SpanLabel("Nombre de place:    " + event.getNbrPlaceDispo());
                SpanLabel bb = new SpanLabel("Description:    " + event.getDescription());
               SpanLabel date = new SpanLabel("Date:   " + event.getDateEvent());
               SpanLabel adr = new SpanLabel("Adresse:   " + event.getAdresse());
              // PickerComponent date = PickerComponent.createDate(new Date());
               // System.out.println("");
                Button Details = new Button("Details");
               Details.addActionListener((evt) -> {
                 new ParticiperEvent(previous,event).show();
                  });
                
                 Button participer = new Button("Participer");
                 SpanLabel ligne = new SpanLabel("__________________________________________   ", "BlueSeparatorLine" );
                 
              
                 
                 participer.addActionListener((evt) -> {
        //    new ParticiperEvent(event).show();
           //new createPieChartForm(event).show();
            
           
             //  Dialog.show("SUCCESS", "vous aver participer au club", "OK", null);
            
                 if( TaskServiceE.getInstance().ParticiperEvent(event)){
                        
                        
                         Dialog.show("Success", "Vous avez participer a  "+event.getNomEvent(),"ok",null); 
                   
                        }
                    else{
                        Dialog.show("ERROR","Veuillez réessayer","ok",null); 
                 
                        }
                  new TasksListFormE1(previous).show();
                  
        });
                
                  
              
                
                   //  C1.add(titre);
                C2.add(nomclub);
                C3.add(cat);
                C4.add(branche);
               // C6.add(adr);
               // C7.add(date);
                 if(event.getNbrPlaceDispo()!=0)
                 { C8.add(participer);}
                 C8.add(Details);
              // C4.add(branche);
              C8.add(ligne);
              //  C5.add(C1);
                C5.add(C2);
                C5.add(C3);
                C5.add(C4);
                C5.add(C6);
                C5.add(C7);
                C5.add(C8);
               
                
                add(C5);
                             this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
            previous.showBack();
        });     
            }
        }
    }
        
    }


