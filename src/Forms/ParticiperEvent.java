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
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;


/**
 *
 * @author asus
 */
public class ParticiperEvent extends Form{
   public ParticiperEvent(Form previous,Event e) {
          TaskServiceE taskServiceE = new TaskServiceE();

  taskServiceE.ParticiperEvent(e);
         Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Container C3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Container C4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
           Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
           Container C6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C7 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            setTitle("Event");
           
           SpanLabel nomclub= new SpanLabel("NomEvent:   " + e.getNomEvent());
                SpanLabel cat = new SpanLabel("categorie:   " + e.getCategorieEvent());
                SpanLabel branche = new SpanLabel("nbrPlaceDispo:    " + e.getNbrPlaceDispo());
                SpanLabel bb = new SpanLabel("description:    " + e.getDescription());
               SpanLabel date = new SpanLabel("date:   " + e.getDateEvent());
               SpanLabel adr = new SpanLabel("adresse:   " + e.getAdresse());
               
                C2.add(nomclub);
                C1.add(C2);
                 C3.add(cat);
                 C1.add(C3);
                C4.add(branche);
                C1.add(C4);
                C5.add(bb);
                C1.add(C5);
                C6.add(date);
                C1.add(C6);
                 C7.add(adr);
                C1.add(C7);
               add(C1);
      
                             this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
             new TasksListFormE1(previous).show();
        });   
}
   
}
