/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.forms;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import com.esprit.pidev.forms.ListAbonneRestoForm;
import com.esprit.pidev.models.AbonneResto;
import com.esprit.pidev.services.AbonneRestoService;
import com.teknikindustries.bulksms.SMS;
/**
 *
 * @author ASUS
 */
public class rechercheAbonneResto {
    private Form current;
    private Resources theme;
    
    Form f;
    Button Qplus;
    Button Qm;
    Button payer;
    float mnt = 0;
    Button cmd ,mail;
    TextField txtSearch;

    ArrayList<AbonneResto> Pr ;
    
    
        public void start(String search) {
        if (current != null) {
            current.show();
            return;
            
            
            
               
        
        }
      

        f = new Form("Reservation", BoxLayout.y());
        
        
     /*     f.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
              
  HomeForm b = new HomeForm();
              b.show();        });*/
          ConnectionRequest con = new ConnectionRequest();

////        f.getToolbar().addCommandToLeftBar("<", null, (ev) -> {
////            AfficheProduit h = new AfficheProduit();
////            h.getF().show();
//
//        });

        Container cont = new Container(new BoxLayout(BoxLayout.Y_AXIS));

      //  Button cmd = new Button("SMS");
      //  mail =  new Button("MAIL");
     //   txtSearch = new TextField();
 //Button btnSearch = new Button("rechercher");
    //   txtSearch.setHint("rechercher reservation");
     //  cont.add(txtSearch); 
       
      

       
        cont.setScrollableX(false);
        cont.setScrollableY(false);

        f.add(cont);
//        f.add(cmd);
      //  f.add(mail);


        f.show();
               Pr = new AbonneRestoService().rechercher(search);



                for (AbonneResto p : Pr) {

                    Container container = new Container(new FlowLayout());
                    Label LB = new Label();
                    Container de = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    de.add(LB);
                    Container lesProduits = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                    
                    
                    String id = String.valueOf(p.getId());
                    String absence = String.valueOf(p.getAbsence());
                    String etat = String.valueOf(p.getEtat());
                    String nom = String.valueOf(p.getNom());
                    String typePension = String.valueOf(p.getTypePension());
                    String typeAbo = String.valueOf(p.getTypeAbo());


                    

                    Label nomprp = new Label(p.getNom());
                    Label typeA = new Label("type abonnement : " + typeAbo);
                    Label typeP = new Label("type pensiont : " + typePension);
                    Label et = new Label("etat : " + etat);
                    Label ab = new Label("nombres d'absence : " + absence);

                    
                   

                    payer = new Button("payer"); //supp
                  

                  

                    container.add(lesProduits);
                    f.add(container);
                    f.add(nomprp);
                    f.add(typeA);
                    f.add(typeP);
                    f.add(et);
                    f.add(ab);

                    f.add(payer);
                  
                   

              /*      Qm.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            {
                                if (p.getQuantite() > 1) {
                                    ServicePanier pn = new ServicePanier();
                                    pn.Quantitemoin(p.getId());
                                    AffichePanier p = new AffichePanier();
                                      

                                    
                                    p.getF().show();
                                  
                                } else {
                                    Dialog.show("Erreur", "Quantité!!!!!!!", "Ok", null);
                                }
                            }

                        }

                    });*/
                    
                    
                  
             
                    
                    
                    
                    
                    

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

               

                f.refreshTheme();

            

        
   //     NetworkManager.getInstance().addToQueue(con);

      
        
        
        
        
         
     
        
        
        
        }
}
