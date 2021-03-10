package com.uniyaz.components;

import com.uniyaz.data.IcerikDao;
import com.uniyaz.data.KatagoriDao;
import com.uniyaz.domain.Icerik;
import com.uniyaz.domain.Katagori;
import com.vaadin.data.Item;
import com.vaadin.ui.*;

import java.sql.Blob;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BodyContentLoyout extends GridLayout {
    private GridLayout gridLayout;
private String ADI,ID ,IcerikDetay,IcerikBaslik;
private int KatagoriID,IcerikID;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    private int temp;
    public BodyContentLoyout() {

        addStyleName("outlined");
        setSizeFull();

        generateMatrixGrid(3, 3);
    }

    private void generateMatrixGrid(final int rows, final int columns) {
        removeAllComponents();
        setRows(rows);
        setColumns(columns);

      //  for (int row = 0; row < getRows(); row++) {
      //      for (int col = 0; col < getColumns(); col++) {
               // final LayoutChildComponent child = new LayoutChildComponent(sample, false);
        addComponent(new Label("Caption"), 0, 1);
        addComponent(new Label("Caption"), 1, 1);
        addComponent(new Label("Caption"), 2, 1);
        addComponent(new Label("Caption"), 0, 2);

      //  addComponent(child);
        setRowExpandRatio(2, 0.0f);
        setColumnExpandRatio(2, 0.0f);
             //   setRowExpandRatio(row, 0.0f);
             //   setColumnExpandRatio(col, 0.0f);
       //     }
      //  }
    }

    public void generateContent(final int columns,int katagori_id) {
        removeAllComponents();
        //  setRows(rows);
        setColumns(columns);

        IcerikDao icerikDao = new IcerikDao();
        List<Icerik> IcekleListe = icerikDao.tumIcerikiGetir(katagori_id);
        for (Icerik katagori : IcekleListe) {
            addComponent(new Label(katagori.getICERIK_BASLIK()));
            setRowExpandRatio(2, 0.0f);
            setColumnExpandRatio(2, 0.0f);
        }
    }

    public void ContentKonuKayit() {
        removeAllComponents();
        setRows(3);
        setColumns(1);

        FormLayout sample = new FormLayout();
        sample.setMargin(true);
        sample.addStyleName("outlined");
        sample.setSizeFull();


//        TextField firstName = new TextField("ID");
//        firstName.addValueChangeListener(event -> updateID((String) event.getProperty().getValue()));

        TextField katagoriAdi = new TextField("ADI");
        katagoriAdi.addValueChangeListener(event -> updateAdi((String) event.getProperty().getValue()));

        VerticalLayout TEXT = new VerticalLayout();

        NativeButton save = new NativeButton("Kaydet");
        HorizontalLayout actions = new HorizontalLayout();
        actions.addComponents(save);

        TEXT.addComponents(katagoriAdi,actions);

        save.addClickListener( e -> {
            KatagoriDao katagoriDao=new KatagoriDao();
            katagoriDao.katagoriEkle(ADI);
            //  bodyContentLoyout.generateContent(3,3,KonuBasligi);
            // ((LayoutUI) UI.getCurrent()).getContentLayout().setPanelContent("ANASAYFA");
            // ((LayoutUI) UI.getCurrent()).getContentLayout().setIcerik("ANASAYFA");
        });

        addComponent(TEXT);

        //  addComponent(new Label("ID"), 0, 1);
        //  addComponent(sample, 0, 2);
        //   addComponent(new Label("EKLE"), 1, 2);
        //   addComponent(new Label("ORACLE4"), 0, 2);

        //  addComponent(child);
        setRowExpandRatio(2, 0.0f);
        setColumnExpandRatio(2, 0.0f);
        //   setRowExpandRatio(row, 0.0f);
        //   setColumnExpandRatio(col, 0.0f);
        //     }
        //  }
    }


    private void updateCaption(String DEGER) {
       setCaption(DEGER);
    }
    private void updateAdi(String DEGER) {
       ADI=DEGER;
    }
    private void updateID(String DEGER) {
        ID=DEGER;
    }

    private void updateKatagoriID(int DEGER) {
        KatagoriID=DEGER;
    }




    private void updateBaslik(String DEGER) {
        ADI=DEGER;
    }
    private void updateIcerikID(int DEGER) {
        IcerikID=DEGER;
    }
    private void updateIcerikDetay(String DEGER) {
        IcerikDetay=DEGER;
    }

    public String getIcerikDetay() {
        return IcerikDetay;
    }

    public void setIcerikDetay(String icerikDetay) {
        IcerikDetay = icerikDetay;
    }

    public String getIcerikBaslik() {
        return IcerikBaslik;
    }

    public void setIcerikBaslik(String icerikBaslik) {
        IcerikBaslik = icerikBaslik;
    }

    public int getKatagoriID() {
        return KatagoriID;
    }

    public void setKatagoriID(int katagoriID) {
        KatagoriID = katagoriID;
    }

    public int getIcerikID() {
        return IcerikID;
    }

    public void setIcerikID(int icerikID) {
        IcerikID = icerikID;
    }

    public void ContentIcerikKayit() {

        removeAllComponents();
        setRows(6);
        setColumns(1);


        List<String> data;
        KatagoriDao katagoriDao=new KatagoriDao();
        List<Katagori> katagoriList=katagoriDao.tumKatagoriGetir();
        NativeSelect katagoriSelect= new NativeSelect("KATAGORI");
        katagoriSelect.setNullSelectionAllowed(false);
        for(Katagori katagori:katagoriList){
            katagoriSelect.addItem(katagori.getName());
        int itemId = katagori.getId();
        setTemp(itemId);
        katagoriSelect.setData(itemId);
        katagoriSelect.addValueChangeListener(event -> {
            updateKatagoriID((Integer) getTemp());
            setKatagoriID(katagori.getId());
        });

        }

      //  katagoriSelect.setEmptySelectionAllowed(false);
       // katagoriSelect.setSelectedItem(data.get(2));
        addComponents(katagoriSelect);
        katagoriSelect.setWidth("50px");


        TextField icerikBaslik = new TextField("ICERIK_BASLIK");
        icerikBaslik.addValueChangeListener(event -> setIcerikBaslik((String) event.getProperty().getValue()));

        TextField icerikDetay = new TextField("ICERIK_DETAY");
        icerikDetay.addValueChangeListener(event -> setIcerikDetay((String) event.getProperty().getValue()));

       // TextField sonuc = new TextField("SONUC");
        VerticalLayout TEXT = new VerticalLayout();

        NativeButton save = new NativeButton("Kaydet");
        //NativeButton reset = new NativeButton("Reset");
        HorizontalLayout actions = new HorizontalLayout();
        actions.addComponents(save);

        TEXT.addComponents(icerikBaslik,icerikDetay,actions);

        save.addClickListener( e -> {
            IcerikDao icerikDao =new IcerikDao();
            int katagori_idDegeri=getKatagoriID();
            String icerikBaslikDegeri=getIcerikBaslik();
            String icerikDetayDegeri=getIcerikDetay();
            icerikDao.icerikEkle(katagori_idDegeri,icerikBaslikDegeri,icerikDetayDegeri);
            //  bodyContentLoyout.generateContent(3,3,KonuBasligi);
            // ((LayoutUI) UI.getCurrent()).getContentLayout().setPanelContent("ANASAYFA");
            // ((LayoutUI) UI.getCurrent()).getContentLayout().setIcerik("ANASAYFA");
        });
        //  for (int row = 0; row < getRows(); row++) {
        //      for (int col = 0; col < getColumns(); col++) {
        // final LayoutChildComponent child = new LayoutChildComponent(sample, false);

        addComponent(TEXT);


        setRowExpandRatio(2, 0.0f);
        setColumnExpandRatio(2, 0.0f);
        //   setRowExpandRatio(row, 0.0f);
        //   setColumnExpandRatio(col, 0.0f);
        //     }
        //  }
    }

    public void ContentKonuListele() {
        removeAllComponents();
        setRows(1);
        setColumns(1);
       // Table table = new Table();
       // table.addStyleName("components-inside");
        Table characters = new Table("Konu Listesi");
        characters.addContainerProperty("ID", Integer.class, null);
        characters.addContainerProperty("KONU", String.class, null);
        characters.addContainerProperty("GUNCELLE", Button.class, null);
        characters.addContainerProperty("SIL", Button.class, null);

        KatagoriDao katagoriDao=new KatagoriDao();
        List<Katagori> katagoriListe =katagoriDao.tumKatagoriGetir();

        for(Katagori katagori:katagoriListe){

            Object newItemId = characters.addItem();
            Item row1 = characters.getItem(newItemId);
            row1.getItemProperty("ID").setValue(katagori.getId());
            row1.getItemProperty("KONU").setValue(katagori.getName());

        int itemId = katagori.getId();
        Button guncelleButton = new Button("GUNCELLE");
        guncelleButton.setData(itemId);
        guncelleButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                //yazarDao.deleteYazar(yazar);
                Integer iid = (Integer)event.getButton().getData();
                Notification.show( iid.intValue() +"KAYIT guncellendi");

            }
        });

        Button deleteButton = new Button("SİL");
            deleteButton.setData(itemId);
        deleteButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
               //yazarDao.deleteYazar(yazar);
                Integer iid = (Integer)event.getButton().getData();
                KatagoriDao katagoriDao1=new KatagoriDao();
                katagoriDao.katagoriSil(iid);
                Notification.show( iid.intValue() +"KAYIT SİLİNDİ");
            }
        });

            row1.getItemProperty("GUNCELLE").setValue(guncelleButton);
            row1.getItemProperty("SIL").setValue(deleteButton);


        }
        characters.setHeight("500px");
        characters.setPageLength(characters.size());
        addComponents(characters);

    }


    public void ContentIcerikListele() {
        removeAllComponents();
        setRows(1);
        setColumns(1);
        // Table table = new Table();
        // table.addStyleName("components-inside");

        Table characters = new Table("ICERIK Listesi");
        characters.addContainerProperty("ICERIK_ID", Integer.class, null);
        characters.addContainerProperty("KATAGORI_ADI", String.class, null);
        characters.addContainerProperty("BASLIK", String.class, null);
        characters.addContainerProperty("DETAY", String.class, null);
        characters.addContainerProperty("", HorizontalLayout.class, null);
       // characters.addContainerProperty("GUNCELLE", Button.class, null);
       // characters.addContainerProperty("SIL", Button.class, null);

        KatagoriDao katagori=new KatagoriDao();

        IcerikDao icerikDao=new IcerikDao();
        List<Icerik> icerikListe =IcerikDao.tumIcerikiGetir();

        for(Icerik icerik:icerikListe){
            Integer itemId = new Integer(icerik.getICERIK_ID());
            Object newItemId = characters.addItem();
            Item row1 = characters.getItem(newItemId);
            row1.getItemProperty("ICERIK_ID").setValue(icerik.getICERIK_ID());
            String katagori_adi=katagori.katagoriGetir(icerik.getKATAGORI_ID()).getName();
            row1.getItemProperty("KATAGORI_ADI").setValue(katagori_adi);
            row1.getItemProperty("BASLIK").setValue(icerik.getICERIK_BASLIK());
            row1.getItemProperty("DETAY").setValue(icerik.getICERIK_DETAY());

            HorizontalLayout A= new HorizontalLayout();

            Button guncelleButton = new Button("GUNCELLE");
            guncelleButton.setData(itemId);
            guncelleButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    //yazarDao.deleteYazar(yazar);
                    Integer iid = (Integer)event.getButton().getData();
                    Notification.show( iid.intValue() +"KAYIT guncellendi");

                }
            });

            Button deleteButton = new Button("SİL");
            deleteButton.setData(itemId);
            deleteButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    //yazarDao.deleteYazar(yazar);
                    IcerikDao icerikDao =new IcerikDao();

                    Integer iid = (Integer)event.getButton().getData();
                    icerikDao.icerikSil(iid.intValue());
                    Notification.show( iid.intValue() +"KAYIT SİLİNDİ");
                }
            });
            A.addComponents(guncelleButton,deleteButton);
            row1.getItemProperty("").setValue(A);


        }
        characters.setHeight("250px");
        characters.setPageLength(characters.size());

        //table.setPageLength(10);
        addComponents(characters);

    }
}
