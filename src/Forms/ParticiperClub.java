/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Models.Club;
import Services.TaskService;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;



/**
 *
 * @author asus
 */
public class ParticiperClub extends Form{
   public ParticiperClub(Form previous,Club c) {
          TaskService taskService = new TaskService();
       
  taskService.ParticiperClub(c);
         Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Container C3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
         Container C4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
           Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
           Container C6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C7 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            setTitle("le club");
            Label l1=new Label("Nom club:  ");
            SpanLabel sujet = new SpanLabel(  c.getNomClub());
           Label l2=new Label("Activite:   ");
                SpanLabel desc = new SpanLabel(c.getActiviteClub());
               //Label l3=new Label("Br:   ");
               //SpanLabel bra= new SpanLabel(c.getEffectif());
               SpanLabel br = new SpanLabel("effectif:    " + c.getEffectif());
               C2.add(l1);
                C2.add(sujet);
                C1.add(C2);
                 C3.add(l2);
                C3.add(desc);
                C1.add(C3);
                C4.add(br);
                C1.add(C4);
               add(C1);
                                    this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
           // previous.showBack();
             new TasksListForm1(previous).show();
        });  
         
}
   
}
