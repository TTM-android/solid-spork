package com.example.select2;

import java.util.ArrayList;

public class Parent {
    static final int TYPE1 = 0;
    static final int TYPE2 = 1;
    static final int TYPE3 = 2;
    static final int TYPE4 = 3;
//    static final int TYPE5 = 4;
    private String tittle, des, stidk="";
    private int type;

    ArrayList<Child_type> type1ArrayList;

    public Parent(String tittle, String des, String stidk, ArrayList<Child_type> type1ArrayList,int type) {
        this.tittle = tittle;
        this.des = des;
        this.stidk = stidk;
        this.type = type;
        this.type1ArrayList = type1ArrayList;
    }

    public Parent(String tittle, ArrayList<Child_type> type1ArrayList, int type) {
        this.tittle = tittle;
        this.type = type;
        this.type1ArrayList = type1ArrayList;
    }

    public Parent(int type) {
        this.type = type;
    }

    public ArrayList<Child_type> getType1ArrayList() {
        return type1ArrayList;
    }

    public void setType1ArrayList(ArrayList<Child_type> type1ArrayList) {
        this.type1ArrayList = type1ArrayList;
    }

    public Parent(String tittle, String des, ArrayList<Child_type> type1ArrayList,int type) {
        this.tittle = tittle;
        this.des = des;
        this.type1ArrayList = type1ArrayList;
        this.type = type;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDes() {
        return des;
    }

    public String getStidk() {
        return stidk;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setStidk(String stidk) {
        this.stidk = stidk;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
