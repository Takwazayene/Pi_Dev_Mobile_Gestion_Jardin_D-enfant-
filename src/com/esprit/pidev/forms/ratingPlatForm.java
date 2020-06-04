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
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.esprit.pidev.models.Plat;
import java.util.ArrayList;
import com.esprit.pidev.services.PlatService;

/**
 *
 * @author ASUS
 */
public class ratingPlatForm  extends SideMenuBaseForm{
    Style s ;
    Image star ;
        ArrayList<Plat> plats ;

      private static final int[] COLORS = {0xf8e478, 0x60e6ce, 0x878aee};
    private static final String[] LABELS = {"Design", "Coding", "Learning"};
        ConnectionRequest connectionRequest ;

   public ratingPlatForm(Resources res) {
     super("Plats", BoxLayout.y());

    
       this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        
       Container cont = new Container(new BoxLayout(BoxLayout.Y_AXIS));
       Button btnSearch = new Button("search");

        cont.setScrollableX(false);
        cont.setScrollableY(false);
        this.add(cont);
        
        
      
        this.show();
      ConnectionRequest con = new ConnectionRequest();
            Container LesUtilisateurs = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            
                    Slider starRank = new Slider();
     plats = new PlatService().getList();

                
              //  plats =  new  PlatService().getList2(new String(con.getResponseData()));
                
                for (Plat user : plats) {
                    Container container = new Container(new FlowLayout());
                    Label LB = new Label("Nom");
                    Container de = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    de.add(LB);
                    Container detailsContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    detailsContainer.add(new Label(user.getNom()));
                   // detailsContainer.add(user.getPrix());
                   detailsContainer.add(user.getDetails());
                  //  detailsContainer.add(String.valueOf(user.getNote()));
                    container.add(detailsContainer);
                    Container ra = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    
                        ra.addComponent(FlowLayout.encloseCenter(createStarRankSlider(user.getNom(),user.getId())));


                        container.add(ra);
                  add(container);
                }
            refreshTheme();
            
        
     
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
                                new Label("  Les ", "WelcomeBlue"),
                                new Label(" plats", "WelcomeWhite")
                        ));
        titleComponent.setUIID("BottomPaddingContainer");
        tb.setTitleComponent(titleComponent);
        
        Label separator = new Label("", "BlueSeparatorLine");
        separator.setShowEvenIfBlank(true);
     //  add(BorderLayout.NORTH, separator);
       
       ///////////////////////////
       
   

          


  

        setupSideMenu(res); 
        
         
         //
     
     
     
     
     
     
        
    }
   
   
         private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);
}
   
   
   
private Slider createStarRankSlider(String sa , int id) {
    Slider starRank = new Slider();
    starRank.setEditable(true);
    starRank.setMinValue(0);
    starRank.setMaxValue(5);
    Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
            derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
    Style s = new Style(0xffff33, 0, fnt, (byte)0);
    Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    s.setOpacity(100);
    s.setFgColor(0);
    Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
    initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
    starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
                                               starRank.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Dialog.show(sa, String.valueOf(starRank.getProgress()), "OK", "cancel");
                        double vte = Double.parseDouble(String.valueOf(starRank.getProgress()));
                        System.out.println(starRank.getProgress());
                         ConnectionRequest con = new ConnectionRequest();
       con.setUrl("http://localhost/devitt2/devitt2/web/app_dev.php/resto/plats/RateMobile?&id=" + id+ "&note=" + vte);
                        System.out.println(vte);
          NetworkManager.getInstance().addToQueue(con);
                     //   rate.setText(String.valueOf(starRank.getProgress()));
                    }
                                
                   
                }); 
    return starRank;}


    public void init(Object context) {
     //   theme = UIManager.initFirstTheme("/theme");
       // Toolbar.setGlobalToolbar(true);

    

   
        
        
       // hi.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
//        TextField txtSearch = new TextField();
//        Container cont = new Container(new BoxLayout(BoxLayout.X_AXIS));
//        Button btnSearch = new Button("search");
//        txtSearch.setHint("Search User");
//        cont.add(btnSearch);
////        btnSearch.addActionListener(e -> {
////            new Search().start(txtSearch.getText());
////        });
//        cont.add(txtSearch);
//        cont.setScrollableX(false);
//        cont.setScrollableY(false);
//        hi.add(cont);
//        hi.add(new Label("Les Utilisateurs"));
//        
//       // new habchkleu().insertHabchkleu(hi);
//        hi.show();
//        ConnectionRequest con = new ConnectionRequest();
//        con.setUrl("http://localhost/Roussia/select.php");
//        con.addResponseListener(new ActionListener<NetworkEvent>() {
//            Container LesUtilisateurs = new Container(new BoxLayout(BoxLayout.X_AXIS));
//            
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                
//                ArrayList<Actualites> users =  new  ServiceActualites().getListUtilisateur(new String(con.getResponseData()));
//                for (Actualites user : users) {
//                    Container container = new Container(new FlowLayout());
//                    Container detailsContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
//                    detailsContainer.add(new Label(user.getTitre_Act()));
//                    detailsContainer.add(user.getDescription_Act());
//                    container.add(detailsContainer);
//                    hi.add(container);
//                }
//                hi.refreshTheme();
//            }
//        });
       // NetworkManager.getInstance().addToQueue(con);
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
    

