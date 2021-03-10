package com.uniyaz.ui;

import com.uniyaz.components.*;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/*
*
* @author Atilla Gökhan KARTAL
* @since
*
*/
@Theme("mytheme")
@Widgetset("com.uniyaz.MyAppWidgetset")
public class LayoutUI extends UI {



    @Override
    protected void init(VaadinRequest vaadinRequest) {

        MainLayout main=new MainLayout();
        main.setSizeFull();
        setContent(main);
    }




}