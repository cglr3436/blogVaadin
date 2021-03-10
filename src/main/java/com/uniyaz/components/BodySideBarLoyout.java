package com.uniyaz.components;

import com.uniyaz.data.IcerikDao;
import com.uniyaz.data.KatagoriDao;
import com.uniyaz.domain.Icerik;
import com.uniyaz.domain.Katagori;
import com.uniyaz.ui.LayoutUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.util.List;

public class BodySideBarLoyout extends VerticalLayout {
    public BodySideBarLoyout(BodyContentLoyout bodyContentLoyout) {
        setSizeFull();
       // String KonuBasligi="  ANASAYFA  ";
        KatagoriDao katagoriDao=new KatagoriDao();
       List<Katagori> katagoriListe =katagoriDao.tumKatagoriGetir();

for(Katagori katagori:katagoriListe){
    Button buttonl1 = new Button(katagori.getName());
    buttonl1.setSizeFull();
    buttonl1.addClickListener( e -> {
        bodyContentLoyout.generateContent(3,katagori.getId());
        // ((LayoutUI) UI.getCurrent()).getContentLayout().setPanelContent("ANASAYFA");
        // ((LayoutUI) UI.getCurrent()).getContentLayout().setIcerik("ANASAYFA");
    });
    setSizeUndefined();
    addComponent(buttonl1);
    setExpandRatio(buttonl1,1f);

}


    }



}
