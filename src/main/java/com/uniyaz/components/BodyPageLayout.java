package com.uniyaz.components;

import com.vaadin.ui.HorizontalLayout;

public class BodyPageLayout extends HorizontalLayout {

    private BodyContentLoyout bodyContentLoyout=new BodyContentLoyout();;

    public BodyContentLoyout getBodyContentLoyout() {
        return bodyContentLoyout;
    }

    public BodyPageLayout() {
        this.setSizeFull();

      //  BodyContentLoyout bodyContentLoyout=new BodyContentLoyout();

        BodySideBarLoyout bodySideBarLoyout=new BodySideBarLoyout(bodyContentLoyout);
        this.addComponent(bodySideBarLoyout);


        this.addComponent(bodyContentLoyout);


        this.setExpandRatio(bodySideBarLoyout,2f);
        this.setExpandRatio(bodyContentLoyout,8f);

    }


}
