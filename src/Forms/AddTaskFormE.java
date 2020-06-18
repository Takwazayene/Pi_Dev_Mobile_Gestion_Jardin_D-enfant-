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
import com.codename1.io.NetworkManager;
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import java.util.Date;


/**
 *
 * @author aissa
 */
public class AddTaskFormE extends Form {

    public AddTaskFormE(Form previous) {
        super("Ajouter un event", BoxLayout.y());

        TextField nome= new TextField(null, "Nom event");
        TextField activite = new TextField(null, "categorie");
         TextField effectif = new TextField(null, "nbrPlace");
         PickerComponent datePicker = PickerComponent.createDate(new Date());
         TextField desc = new TextField(null, "description");
          TextField adr = new TextField(null, "adresse");
          
        
 
         //TextField date = new TextField(null, "description");
        Button btn = new Button("Ajouter un event");
        

        btn.addActionListener((evt) -> {
            if ((nome.getText().length() == 0) || (activite.getText().length() == 0)) {
                Dialog.show("Alert", "Please fill all the fields", "OK", null);
            } else {
                try {
                    Event e = new Event(nome.getText(),activite.getText(),Integer.parseInt(effectif.getText()),desc.getText(),adr.getText());
                    if (new TaskServiceE().addTask(e)) {
                        Dialog.show("SUCCESS", "Event ajouté", "OK", null);
                    } else {
                        Dialog.show("ERROR", "Server error", "OK", null);
                    }
                } catch (NumberFormatException e) {
                    Dialog.show("ERROR", "Effectif doit etre un entier", "OK", null);
                }

            }
         
        });

        this.addAll(nome, activite, effectif, datePicker, desc, adr, btn);

        this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
            previous.showBack();
        });

 }
         
    }


