package com.uniyaz.components;

import com.vaadin.ui.VerticalLayout;

public class MainLayout extends VerticalLayout {

    public MainLayout() {
        setSizeFull();

        BodyPageLayout bodyPageLayout=new BodyPageLayout();

        HeaderPageLayout headerPageLayout=new HeaderPageLayout(bodyPageLayout);
        this.addComponent(headerPageLayout);


        this.addComponent(bodyPageLayout);

        FooterPageLayout footerPageLayout =new FooterPageLayout();
        this.addComponent(footerPageLayout);

        this.setExpandRatio(headerPageLayout, 1f);
        this.setExpandRatio(bodyPageLayout, 8f);
        this.setExpandRatio(footerPageLayout, 1f);


    }
}
