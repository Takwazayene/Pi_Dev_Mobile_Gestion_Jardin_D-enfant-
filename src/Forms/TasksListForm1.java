/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Forms.ParticiperClub;
import Models.Club;
import Services.TaskService;
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
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

import java.util.List;

/**
 *
 * @author aissa
 */
public class TasksListForm1 extends Form {
   public TasksListForm1(Form previous) {
        
       setTitle("les clubs");
        //etToolbar().addCommandToLeftBar("back", null, e -> new WalkthruForm(res).show());
       // getToolbar().addCommandToRightBar("Reclamer", null, e -> new HomeReclamation(theme).show());
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
         Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
           Container C11 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label titre = new Label("Liste des clubs","WelcomeBlue");
         setLayout(new FlowLayout(CENTER,TOP));
           TextField textchercher = new TextField();
                 Button Recherche = new Button("Recherche");
               C11.addAll(textchercher,Recherche);
               C1.add(titre);
               add(C11);
               add(C1);
         TaskService taskService = new TaskService();
        List<Club> clubs = taskService.getAllTasks();
      
        if (clubs!= null && !clubs.isEmpty()) {
            for (Club club: clubs) {
               int IdE=club.getId();
                Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
  Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
 Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                Font font = titre.getUnselectedStyle().getFont();
                Font newFont = Font.createSystemFont(font.getFace(), Font.STYLE_BOLD, font.getSize());
                titre.getUnselectedStyle().setFont(newFont);
                SpanLabel nomclub= new SpanLabel("Nom Club:   " + club.getNomClub());
                SpanLabel cat = new SpanLabel("Activite:   " + club.getActiviteClub());
                SpanLabel branche = new SpanLabel("effectif:    " + club.getEffectif());
              
                
               Button Details = new Button("Details");
              /* Details.addActionListener((evt) -> {
                 new ParticiperClub(previous,club).show();
                  });*/
               
                Details.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new ParticiperClub(previous,club).show();
                }
            });
               Button participer = new Button("Participer");
                 SpanLabel ligne = new SpanLabel("__________________________________________   ", "BlueSeparatorLine" );
                 participer.addActionListener((evt) -> {
           // new ParticiperClub(club).show();
          
                 if( TaskService.getInstance().ParticiperClub(club)){
                        
                        
                         Dialog.show("Success", "Vous avez participer au club "+club.getNomClub(),"ok",null); 
                   
                        }
                    else{
                        Dialog.show("ERROR","Veuillez réessayer","ok",null); 
                 
                        }
                  new TasksListForm1(previous).show();

              //  Dialog.show("SUCCESS", "vous aver participer au club", "OK", null);
            
               });
               
                C2.add(nomclub);
               // C3.add(cat);
            //    C1.add(branche);
                C6.add(participer);
                C6.add(Details);
                // C1.add(Recherche);
                C6.add(ligne);
               C4.add(branche);
                //C5.add(C11);
                C5.add(C2);
                C5.add(C3);
                C5.add(C4);
               C5.add(C6);
                
                add(C5);
                        this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
            previous.showBack();
        });  
            }
     
        }
          
              Recherche.addActionListener(new ActionListener() {
             
              @Override
               public void actionPerformed(ActionEvent evt) {
                  Form f1 = new Form(BoxLayout.y()); 
                 
                  Label titre = new Label("                Liste des clubs","WelcomeBlue");
                   f1.add(titre);
                 
        //TaskService taskService = new TaskService();
       
                   String rech = textchercher.getText();
                 // List<Club> clubs = taskService.rech(rech);
                   //   List<Club> clubs = taskService.getAllTasks();
                   
                     for(Club club:TaskService.getInstance().rech(rech)){
                                 int IdE=club.getId();
                Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
  Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
 Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                 
                Font font = titre.getUnselectedStyle().getFont();
               Font newFont = Font.createSystemFont(font.getFace(), Font.STYLE_BOLD, font.getSize());
                titre.getUnselectedStyle().setFont(newFont);
                SpanLabel nomclub= new SpanLabel("Nom Club:   " + club.getNomClub());
                SpanLabel cat = new SpanLabel("Activite:   " + club.getActiviteClub());
                SpanLabel branche = new SpanLabel("effectif:    " + club.getEffectif());
              //  SpanLabel branche = new SpanLabel("Branche" + stage.getBranche());
                SpanLabel ligne = new SpanLabel("__________________________________________   ", "BlueSeparatorLine" );
               // System.out.println(""); 
               Button Details = new Button("Details");
              
                Details.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new ParticiperClub(previous,club).show();
                }
            });
                
                 Button participer = new Button("Participer");
                 participer.addActionListener(new ActionListener() {
           // new ParticiperClub(club).show();
           @Override
                public void actionPerformed(ActionEvent evt) {
                 if( TaskService.getInstance().ParticiperClub(club)){
                        
                        
                         Dialog.show("Success", "Vous avez participer au club "+club.getNomClub(),"ok",null); 
                   
                        }
                    else{
                        Dialog.show("ERROR","Veuillez réessayer","ok",null); 
                 
                        }
                  new TasksListForm1(previous).show();

              //  Dialog.show("SUCCESS", "vous aver participer au club", "OK", null);
                }
               });
                   f1.setTitle("les clubs");     //  C1.add(titre);
        
              //  C1.add(titre);
                C2.add(nomclub);
               // C3.add(cat);
             //   C1.add(branche);
              C6.add(participer);
               C6.add(Details);
                // C1.add(Recherche);
               C6.add(ligne);
               C4.add(branche);
              //  C5.add(C1);
                C5.add(C2);
                C5.add(C3);
                C5.add(C4);
               C5.add(C6);
                
               // add(C5);
             f1.add(C5);
          f1.show();
          f1.getToolbar().addMaterialCommandToLeftBar("return", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
          
                    }
        
              
                     
       }
                   
       });  
               
              
    }



}
    

