/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;


import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;

import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;


/**
 *
 * @author aissa
 */
public class HomeForm extends SideMenuBaseForm {

    public HomeForm() {
        super("Home", BoxLayout.y());
        
        Button btnAddTask = new Button("Ajouter un Club");
         Button btnAddTaskE = new Button("Ajouter un Event");
        Button btnTasksList = new Button("Lister les clubs");
        Button btnTasksListE = new Button("Lister les events");
      Button btnTasksList1 = new Button("Participer a un club");
       Button btnTasksList2 = new Button("Participer a un event");
        btnAddTask.addActionListener((evt) -> {
            new AddTaskForm(this).show();
        });
         btnAddTaskE.addActionListener((evt) -> {
            new AddTaskFormE(this).show();
        });
        btnTasksList.addActionListener((evt) -> {
            new TasksListForm(this).show();
        });
        btnTasksList1.addActionListener((evt) -> {
            new TasksListForm1(this).show();
        });
          btnTasksListE.addActionListener((evt) -> {
            new TasksListFormE(this).show();
        });
             btnTasksList2.addActionListener((evt) -> {
            new TasksListFormE1(this).show();
        });
          
 this.addAll(new Label(""), btnAddTask, btnTasksList, btnTasksList1, btnTasksListE, btnAddTaskE,  btnTasksList2); 

    }
    

    @Override
    protected void showOtherForm(Resources res) {
      
      
    
       
    }
   

 
}