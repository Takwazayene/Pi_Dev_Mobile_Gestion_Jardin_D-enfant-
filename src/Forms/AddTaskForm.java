/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Models.Club;
import Services.TaskService;
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;


/**
 *
 * @author aissa
 */
public class AddTaskForm extends Form {

    public AddTaskForm(Form previous) {
        super("Ajouter un club", BoxLayout.y());

        TextField nomclub = new TextField(null, "Nom Club");
        TextField activite = new TextField(null, "Activite");
         TextField effectif = new TextField(null, "effectif");
        
        
        Button btn = new Button("Ajouter le club");
        

        btn.addActionListener((evt) -> {
            if ((nomclub.getText().length() == 0) || (activite.getText().length() == 0)) {
                Dialog.show("Alert", "Please fill all the fields", "OK", null);
            } else {
                try {
                    Club c = new Club(nomclub.getText(),activite.getText(),Integer.parseInt(effectif.getText()));
                    if (new TaskService().addTask(c)) {
                        Dialog.show("SUCCESS", "Club ajouté", "OK", null);
                    } else {
                        Dialog.show("ERROR", "Server error", "OK", null);
                    }
                } catch (NumberFormatException e) {
                    Dialog.show("ERROR", "Effectif doit etre un entier", "OK", null);
                }

            }
         
        });

        this.addAll(nomclub, activite, effectif, btn);

        this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
            previous.showBack();
        });

 }
         
    }


