/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.forms;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.pidev.models.Task;
import com.esprit.pidev.services.TaskService;

/**
 *
 * @author aissa
 */
public class AddTaskForm extends Form {

    public AddTaskForm(Form previous) {
        super("Add a new task", BoxLayout.y());

        TextField tfName = new TextField(null, "Task name");
        TextField tfStatus = new TextField(null, "Status (0 or 1)");
        Button btn = new Button("Add the task");

        btn.addActionListener((evt) -> {
            if ((tfName.getText().length() == 0) || (tfStatus.getText().length() == 0)) {
                Dialog.show("Alert", "Please fill all the fields", "OK", null);
            } else {
                try {
                    Task t = new Task(Integer.parseInt(tfStatus.getText()), tfName.getText());
                    if (new TaskService().addTask(t)) {
                        Dialog.show("SUCCESS", "Task sent", "OK", null);
                    } else {
                        Dialog.show("ERROR", "Server error", "OK", null);
                    }
                } catch (NumberFormatException e) {
                    Dialog.show("ERROR", "Status must be a number", "OK", null);
                }

            }
        });

        this.addAll(tfName, tfStatus, btn);

        this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
            previous.showBack();
        });
    }

}
