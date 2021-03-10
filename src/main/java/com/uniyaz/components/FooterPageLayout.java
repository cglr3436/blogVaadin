package com.uniyaz.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class FooterPageLayout extends HorizontalLayout {
    public FooterPageLayout() {
        setSizeFull();

        Label label = new Label("WordPress tarafından desteklenmektedir - Tüm Hakları Saklıdır © 2019-2021");
        addComponent(label);
        label.setSizeUndefined();
        setComponentAlignment(label, Alignment.MIDDLE_CENTER);
    }
}
