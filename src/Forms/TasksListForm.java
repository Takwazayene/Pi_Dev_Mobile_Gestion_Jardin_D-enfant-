/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Models.Club;
import Services.TaskService;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
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
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import static com.codename1.ui.events.ActionEvent.Type.values;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import java.util.List;

/**
 *
 * @author aissa
 */
public class TasksListForm extends Form {
     EncodedImage imc;
    Image img;
    ImageViewer imv;
    public static String TITRE;
    public static String TITREimage;
    public static String TITREcontenue;
    public static String TITREDATE;
    ComboBox<String> cb1 = new ComboBox();

    public TasksListForm(Form previous) {
         EncodedImage imc;
        Image img;
        ImageViewer imv;
        
        setTitle("les clubs");
        //etToolbar().addCommandToLeftBar("back", null, e -> new WalkthruForm(res).show());
       // getToolbar().addCommandToRightBar("Reclamer", null, e -> new HomeReclamation(theme).show());
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
         Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
             
         Label titre = new Label("Liste des clubs","WelcomeBlue");
         setLayout(new FlowLayout(CENTER,TOP));
         Button stat = new Button("stat");
               C1.add(titre);
                C1.add(stat);
               add(C1);
               
    
        TaskService taskService = new TaskService();
        List<Club> clubs = taskService.getAllTasks();
        if (clubs!= null && !clubs.isEmpty()) {
            for (Club club : clubs) {
               int IdE=club.getId();
                Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
  Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
 Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
               
                Font font = titre.getUnselectedStyle().getFont();
                Font newFont = Font.createSystemFont(font.getFace(), Font.STYLE_BOLD, font.getSize());
                titre.getUnselectedStyle().setFont(newFont);
                SpanLabel nomclub= new SpanLabel("Nom:   " + club.getNomClub());
                SpanLabel cat = new SpanLabel("Categorie:   " + club.getActiviteClub());
                SpanLabel branche = new SpanLabel("Effectif:    " + club.getEffectif());
              //  SpanLabel branche = new SpanLabel("Branche" + stage.getBranche());
              
               // System.out.println("");
                
            ///  Button participer = new Button("Participer");
                 SpanLabel ligne = new SpanLabel("__________________________________________   ", "BlueSeparatorLine" );
               //  participer.addActionListener((evt) -> {
       //   new ParticiperClub(club).show();
           
           
               // Dialog.show("SUCCESS", "vous aver participer au club", "OK", null);
            
       // });*/
                  
                 Button supprimer = new Button("supprimer");
        supprimer.addActionListener(b->{
                    if( TaskService.getInstance().deletClub(club)){
                         Dialog.show("Success", "Vous avez supprimer le club "+club.getNomClub(),"ok",null); 
                        }
                    else{
                           Dialog.show("ERROR","Veuillez réessayer","ok",null); 
                        }
                      new TasksListForm(previous).show();
            });
        
        
         Button modifier = new Button("modifier");
          modifier.addActionListener(a->{
               Form me=new Form("Modifier post ",BoxLayout.y());
             TextField mtfTitre = new TextField(club.getNomClub(),"nom");
           //     Picker    mdpDateE= new Picker();
                TextField mtfDescription=new TextField(club.getActiviteClub(),"activite");
                TextField mtfRating=new TextField(Integer.toString(club.getEffectif()),"effectif ");
               // Container mcnt = new Container(BoxLayout.y());
               Label labelid = new Label (Integer.toString(club.getId()));
      //  Label nbrating = new Label("Nombre de Rating : "+Integer.toString(club.getEffectif()));
              
               // mcnt.add(nbrating);
                
                
                
                Button btnModifier = new Button("Modifier club");
        
                btnModifier.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                if ((mtfTitre.getText().length()==0)||(mtfDescription.getText().length()==0) )
                     Dialog.show("Alert", "Please fill all the fields","ok",null);  
               
                else 
                {
        
                   Club c = new Club(IdE,mtfTitre.getText(), mtfDescription.getText(),Integer.parseInt(mtfRating.getText()));
                    
                    if( TaskService.getInstance().modifier(c)){
                        
                        
                         Dialog.show("Success", "Vous avez modifié le club "+c.getNomClub(),"ok",null); 
                   
                        }
                    else{
                        Dialog.show("ERROR","Veuillez réessayer","ok",null); 
                 
                        }
                  new TasksListForm(previous).show();

                  }                                                 
                }   
                });
                me.addAll(mtfTitre,mtfDescription,mtfRating,btnModifier);
           me.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
             me.show();        
                
            });
                
                   //  C1.add(titre);
                C2.add(nomclub);
                C3.add(cat);
            //    C1.add(branche);
                C6.add(supprimer);
                C6.add(modifier);
               // C6.add(stat);
                C6.add(ligne);
               C4.add(branche);
              //  C5.add(C1);
                C5.add(C2);
                C5.add(C3);
                C5.add(C4);
               C5.add(C6);
                
                add(C5);
                 this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
            previous.showBack();
        }); 
                 
                    
         
          stat.addActionListener(a->{
               Form me=new Form("Nos clubs", new BorderLayout());
           double[] values = new double[]{18,36,2,5,9};
int valu=club.getEffectif();
    // Set up the renderer
    int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN};
    DefaultRenderer renderer = buildCategoryRenderer(colors);
     SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
   
   renderer.setZoomButtonsVisible(true);
    renderer.setZoomEnabled(true);
    renderer.setChartTitleTextSize(20);
    renderer.setDisplayValues(true);
    renderer.setShowLabels(true);
   
    r.setGradientEnabled(true);
    r.setGradientStart(0, ColorUtil.BLUE);
  
    r.setHighlighted(true);
      //  Label nbrating = new Label("Nombre de Rating : "+Integer.toString(club.getEffectif()));
              
               // mcnt.add(nbrating);
                  PieChart chart = new PieChart(buildCategoryDataset("Nos clubs", values), renderer); 
                
                
             
                
                
                ChartComponent c = new ChartComponent(chart);  
    me.add(BorderLayout.CENTER, c);
   
                
           me.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
             me.show();        
                
            });
      
             
    }      
                 
                 
            }
        }
        
       
        Club club=new Club();
   
        
            private DefaultRenderer buildCategoryRenderer(int[] colors) {
    DefaultRenderer renderer = new DefaultRenderer();
    renderer.setLabelsTextSize(15);
    renderer.setLegendTextSize(15);
    renderer.setMargins(new int[]{20, 30, 15, 0});
    for (int color : colors) {
        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
        r.setColor(color);
        renderer.addSeriesRenderer(r);
    }
    return renderer;
}  
                protected CategorySeries buildCategoryDataset(String title, double[] clubs) {
    CategorySeries series = new CategorySeries(title);
    int k = club.getEffectif();
    for (double club : clubs) {
        series.add("Project " + ++k,club);
    }

    return series;
}
    }

