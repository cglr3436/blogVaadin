package com.uniyaz.domain;

import java.sql.Blob;

public class Icerik {

    int ICERIK_ID;
    int KATAGORI_ID;
    String ICERIK_BASLIK;
    String ICERIK_DETAY;
    Blob Resim;

    public Icerik(int ICERIK_ID,int KATAGORI_ID, String ICERIK_BASLIK, String ICERIK_DETAY, Blob resim) {
        this.ICERIK_ID = ICERIK_ID;
        this.KATAGORI_ID = KATAGORI_ID;
        this.ICERIK_BASLIK = ICERIK_BASLIK;
        this.ICERIK_DETAY = ICERIK_DETAY;
        Resim = resim;
    }

    public int getICERIK_ID() {
        return ICERIK_ID;
    }

    public void setICERIK_ID(int ICERIK_ID) {
        this.ICERIK_ID = ICERIK_ID;
    }


    public int getKATAGORI_ID() {
        return KATAGORI_ID;
    }

    public void setKATAGORI_ID(int KATAGORI_ID) {
        this.KATAGORI_ID = KATAGORI_ID;
    }

    public String getICERIK_BASLIK() {
        return ICERIK_BASLIK;
    }

    public void setICERIK_BASLIK(String ICERIK_BASLIK) {
        this.ICERIK_BASLIK = ICERIK_BASLIK;
    }

    public String getICERIK_DETAY() {
        return ICERIK_DETAY;
    }

    public void setICERIK_DETAY(String ICERIK_DETAY) {
        this.ICERIK_DETAY = ICERIK_DETAY;
    }

    public Blob getResim() {
        return Resim;
    }

    public void setResim(Blob resim) {
        Resim = resim;
    }




    public Icerik(int KATAGORI_ID, String ICERIK_BASLIK, String ICERIK_DETAY) {
        this.KATAGORI_ID = KATAGORI_ID;
        this.ICERIK_BASLIK = ICERIK_BASLIK;
        this.ICERIK_DETAY = ICERIK_DETAY;
    }

}
