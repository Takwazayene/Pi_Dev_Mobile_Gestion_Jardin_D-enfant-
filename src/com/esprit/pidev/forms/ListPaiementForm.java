/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.forms;

import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.renderers.XYSeriesRenderer;
import com.codename1.components.MultiButton;
import com.codename1.io.ConnectionRequest;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.esprit.pidev.models.Paiement;
import com.esprit.pidev.services.PaiementService;
import com.teknikindustries.bulksms.SMS;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ListPaiementForm  extends SideMenuBaseForm{
    
      /*   private   Form f,bb,detail;
    private  SpanLabel lb;
    private  Label l2 ;
    private Resources theme;*/
     Form f;
    Button Qplus;
    Button Qm;
    Button payer;
    float mnt = 0;
    Button cmd ,mail;
    TextField txtSearch;

    ArrayList<Paiement> Pr ;
    
  private static final int[] COLORS = {0xf8e478, 0x60e6ce, 0x878aee};
    private static final String[] LABELS = {"Design", "Coding", "Learning"};
       public ListPaiementForm(Resources res) {
                       super("Paiements", BoxLayout.y());

        ConnectionRequest con = new ConnectionRequest();
     Pr = new PaiementService().getList();

      //  f = new Form("Mes paiements", BoxLayout.y());
        
                Image money = res.getImage("money.png");

        
        


        Container cont = new Container(new BoxLayout(BoxLayout.Y_AXIS));

       
        txtSearch = new TextField();
 Button btnSearch = new Button("rechercher");
                btnSearch.setUIID("ButtonStyle");

       txtSearch.setHint("rechercher paiement");
       cont.add(txtSearch); 
       
        btnSearch.addActionListener(e -> {
     if (txtSearch.getText().equals(""))
     {
         Dialog.show("Details", "Please Type What You Are Searching For", "Ok", null);
} else {
             //   Pr = new AbonneRestoService().rechercher(txtSearch.getText());
                 new rechercheAbonneResto().start(txtSearch.getText());

     }
          
       });

       cont.add(btnSearch); 
       
        cont.setScrollableX(false);
        cont.setScrollableY(false);

        this.add(cont);
//     this.add(cmd);
  //  this.add(mail);


  


                for (Paiement p : Pr) {

                    //
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
        
        addButtonBottom(arrowDown, "", 0xd997f1, true);
                    //
                    
                    Container container = new Container(new FlowLayout());
                    Label LB = new Label();
                    Container de = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    de.add(LB);
                    Container lesProduits = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                    
                    
                    String idC = String.valueOf(p.getIdC());
                    String total = String.valueOf(p.getTotal());
                    String type = String.valueOf(p.getType());



                    
                   // Label datee = new Label("date : " +new Label( p.getDate()));

                    Label typee = new Label("type : " + type);
                    Label totaal = new Label("montant : " + total);
                    

                    
                   

                  

                  

                    container.add(lesProduits);
                    this.add(container);
                    this.add(typee);
                    this.add(totaal);


                   

                  
                   

           
                    
                    
                  
             
                    
                    
                    
                    
                    

                 /*   supp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                             ServicePanier pn = new ServicePanier();
                                    pn.DeleteProduitPanier(p.getId());
                                    AffichePanier p = new AffichePanier();
                                      

                                    
                                    p.getF().show();

                        }
                    }); */

                }

               

                this.refreshTheme();

            

        
   //     NetworkManager.getInstance().addToQueue(con);

   /*     cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
  SMS smsTut = new SMS();
                        smsTut.SendSMS("takwa99", "allah240511", "vous avez bien payer votre reservation de restauration ","+21653373409", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
             
            }
        });*/
        
        
      //
Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("logo.png");        
        Image tintedImage = Image.createImage(profilePic.getWidth(), profilePic.getHeight());
        Graphics g = tintedImage.getGraphics();
        g.drawImage(profilePic, 0, 0);
        g.drawImage(res.getImage("gradient-overlay.png"), 0, 0, profilePic.getWidth(), profilePic.getHeight());
        
        tb.getUnselectedStyle().setBgImage(tintedImage);
        
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());

        Button settingsButton = new Button("");
        settingsButton.setUIID("Title");
        FontImage.setMaterialIcon(settingsButton, FontImage.MATERIAL_SETTINGS);
        
        Label space = new Label("", "TitlePictureSpace");
        space.setShowEvenIfBlank(true);
        Container titleComponent = 
                BorderLayout.north(
                    BorderLayout.west(menuButton).add(BorderLayout.EAST, settingsButton)
                ).
                add(BorderLayout.CENTER, space).
                add(BorderLayout.SOUTH, 
                        FlowLayout.encloseIn(
                                new Label("  Mes ", "WelcomeBlue"),
                                new Label("Paiements", "WelcomeWhite")
                        ));
        titleComponent.setUIID("BottomPaddingContainer");
        tb.setTitleComponent(titleComponent);
        
        Label separator = new Label("", "BlueSeparatorLine");
        separator.setShowEvenIfBlank(true);
       // add(BorderLayout.NORTH, separator);
       
       ///////////////////////////
       
   

          

 setupSideMenu(res); 
        this.show();

  

         
        
         
         
    }
          
            
       
          
    private void addButtonBottom(Image arrowDown, String text, int color, boolean first) {
        MultiButton finishLandingPage = new MultiButton(text);
        finishLandingPage.setEmblem(arrowDown);
        finishLandingPage.setUIID("Container");
        finishLandingPage.setUIIDLine1("TodayEntry");
        finishLandingPage.setIcon(createCircleLine(color, finishLandingPage.getPreferredH(),  first));
        finishLandingPage.setIconUIID("Container");
        add(FlowLayout.encloseIn(finishLandingPage));
    }
    
    private Image createCircleLine(int color, int height, boolean first) {
        Image img = Image.createImage(height, height, 0);
        Graphics g = img.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0xcccccc);
        int y = 0;
        if(first) {
            y = height / 6 + 1;
        }
        g.drawLine(height / 2, y, height / 2, height);
        g.drawLine(height / 2 - 1, y, height / 2 - 1, height);
        g.setColor(color);
        g.fillArc(height / 2 - height / 4, height / 6, height / 2, height / 2, 0, 360);
        return img;
    }

    @Override
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();
    }
     
     
 
      private Image colorCircle(int color) {
        int size = Display.getInstance().convertToPixels(3);
        Image i = Image.createImage(size, size, 0);
        Graphics g = i.getGraphics();
        g.setColor(color);
        g.fillArc(0, 0, size, size, 0, 360);
        return i;
    }
    
   

    private XYMultipleSeriesRenderer createChartMultiRenderer() {
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        for(int color : COLORS) {
            XYSeriesRenderer r = new XYSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
            r.setFillPoints(false);
            XYSeriesRenderer.FillOutsideLine outline = new XYSeriesRenderer.FillOutsideLine(XYSeriesRenderer.FillOutsideLine.Type.BELOW);
            outline.setColor(color);
            r.addFillOutsideLine(outline);
            r.setLineWidth(5);
        }
        renderer.setPointSize(5f);
        renderer.setLabelsColor(0);
        renderer.setBackgroundColor(0xffffffff);
        renderer.setApplyBackgroundColor(true);
        renderer.setAxesColor(COLORS[0]);

        renderer.setXTitle("");
        renderer.setYTitle("");
        renderer.setAxesColor(0xcccccc);
        renderer.setLabelsColor(0);
        renderer.setXLabels(5);
        renderer.setYLabels(5);
        renderer.setShowGrid(true);
        
        renderer.setMargins(new int[] {0, 0, 0, 0});
        renderer.setMarginsColor(0xffffff);

        renderer.setShowLegend(false);
        
        renderer.setXAxisMin(3);
        renderer.setXAxisMax(8);
        renderer.setYAxisMin(0);
        renderer.setYAxisMax(10);
        return renderer;
    }
      
     
    
}
