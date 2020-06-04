/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.forms;


import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.esprit.pidev.forms.AddAbonneRestoForm;
import com.esprit.pidev.forms.ListAbonneRestoForm;


/**
 *
 * @author ASUS
 */
public class BaseForm extends Form {
     public BaseForm() {
    }

    public BaseForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }

    public BaseForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }
    
    
    public Component createLineSeparator() {
        Label separator = new Label("", "WhiteSeparator");
        separator.setShowEvenIfBlank(true);
        return separator;
    }
    
    public Component createLineSeparator(int color) {
        Label separator = new Label("", "WhiteSeparator");
        separator.getUnselectedStyle().setBgColor(color);
        separator.getUnselectedStyle().setBgTransparency(255);
        separator.setShowEvenIfBlank(true);
        return separator;
    }

    protected void addSideMenu(Resources res) {
        Toolbar tb = getToolbar();
        Image img = res.getImage("Russia_2018.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        Image profilepic = res.getImage("profile-pic.jpg");
        Image defaultphoto = res.getImage("russia2018.png").scaled(profilepic.getHeight(),profilepic.getWidth());
        
        tb.addComponentToSideMenu(LayeredLayout.encloseIn(
                sl,
                FlowLayout.encloseCenterBottom(
                        new Label(defaultphoto, "PictureWhiteBackgrond"))
        ));
        
    //    tb.addMaterialCommandToSideMenu("Agences", FontImage.MATERIAL_CARD_TRAVEL, e -> new ListAbonneRestoForm(res).show());
       /* tb.addMaterialCommandToSideMenu("Offres", FontImage.MATERIAL_LIST, e -> new OffresForm(res).show());
        tb.addMaterialCommandToSideMenu("Actualités", FontImage.MATERIAL_BACKUP, e -> new Affichage().getF().show());
        tb.addMaterialCommandToSideMenu("Hotels", FontImage.MATERIAL_UPDATE, e -> new AffichageHotels().getF().show());
        tb.addMaterialCommandToSideMenu("Product", FontImage.MATERIAL_UPDATE, e -> new AfficheProduit().getF().show());
        tb.addMaterialCommandToSideMenu("Matchs", FontImage.MATERIAL_UPDATE, e -> new Affichage1().getF().show());
        tb.addMaterialCommandToSideMenu("Equipes", FontImage.MATERIAL_SETTINGS, e -> new EquipeService().findAllEvents());
        tb.addMaterialCommandToSideMenu("Profile", FontImage.MATERIAL_SETTINGS, e -> new ProfileForm(res).show());*/
       
    }
    
}
