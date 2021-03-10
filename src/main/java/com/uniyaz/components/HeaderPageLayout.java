package com.uniyaz.components;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

public class HeaderPageLayout extends HorizontalLayout {

    Label headerlabel = new Label("Universal Yazılım ");
    BodyPageLayout bodyPageLayout;

    public HeaderPageLayout(BodyPageLayout bodyPageLayout) {
        this.bodyPageLayout = bodyPageLayout;
        setSizeFull();

        MenuBar.Command menuCommand = selectedItem -> Notification.show("Action " + selectedItem.getText(), Notification.Type.TRAY_NOTIFICATION);
        MenuBar.Command menuKonuEkleme = selectedItem -> this.bodyPageLayout.
                                                            getBodyContentLoyout().
                                                             ContentKonuKayit();

        MenuBar.Command menuKonuListele = selectedItem -> this.bodyPageLayout.
                getBodyContentLoyout().
                ContentKonuListele();

        MenuBar.Command menuIcerikEkleme = selectedItem -> this.bodyPageLayout.
                getBodyContentLoyout().
                ContentIcerikKayit();

        MenuBar.Command menuIcerikListele = selectedItem -> this.bodyPageLayout.
                getBodyContentLoyout().
                ContentIcerikListele();

        MenuBar menuBar = new MenuBar();
        menuBar.setAutoOpen(true);


        MenuItem konuMenu = menuBar.addItem("KONU", null, null);
        MenuItem konuEkle = konuMenu.addItem("EKLE", null, menuKonuEkleme);
        MenuItem konuListele = konuMenu.addItem("LISTELE", null, menuKonuListele);


        MenuItem icerikMenu = menuBar.addItem("ICERIK", null, null);
        MenuItem icerikEkle = icerikMenu.addItem("EKLE", null, menuIcerikEkleme);
        MenuItem icerikListele = icerikMenu.addItem("LISTELE", null, menuIcerikListele);

        //setSizeUndefined();

        addComponent(menuBar);
        setComponentAlignment(menuBar, Alignment.TOP_CENTER);



//        String KonuBasligi="ANASAYFA";
//
//
//        Button buttonl1 = new Button(KonuBasligi);
//        buttonl1.setSizeFull();
//        buttonl1.addStyleName(ValoTheme.BUTTON_FRIENDLY);
//        buttonl1.addClickListener( e -> {
//            bodyPageLayout.getBodyContentLoyout().generateContentKayit(3,12,KonuBasligi);
//            // ((LayoutUI) UI.getCurrent()).getContentLayout().setPanelContent("ANASAYFA");
//            // ((LayoutUI) UI.getCurrent()).getContentLayout().setIcerik("ANASAYFA");
//        });
//        setSizeUndefined();
//        addComponent(buttonl1);
//        setExpandRatio(buttonl1,1f);

    }

    public void setHeaderlabel(Label headerlabel) {
        this.headerlabel = headerlabel;
    }
}
