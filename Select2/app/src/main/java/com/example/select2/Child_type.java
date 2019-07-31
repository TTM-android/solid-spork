package com.example.select2;

import android.widget.ImageView;

public class Child_type {
    static final int CTYPE1 = 0;
    static final int CTYPE2 = 1;
    static final int CTYPE3 = 2;
    static final int CTYPE4 = 3;
    int img,type;
    boolean isClick = false;

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    private String deal_date;
    private String tittle_deal,tittle;
    private String content_deal;
    private String name,desc,price_saled,price;
    private int color;

    public Child_type(int img, String tittle, int type) {
        this.img = img;
        this.type = type;
        this.tittle = tittle;
    }

    public Child_type(int img, String deal_date, String tittle_deal, String content_deal,int type) {
        this.img = img;
        this.deal_date = deal_date;
        this.tittle_deal = tittle_deal;
        this.content_deal = content_deal;
        this.type = type;
    }

    public Child_type(int img,String tittle,int color,int type) {
        this.img = img;
        this.type = type;
        this.tittle = tittle;
        this.color = color;
    }

    public Child_type(int img, String name, String desc, String price_saled, String price, int type) {
        this.img = img;
        this.type = type;
        this.name = name;
        this.desc = desc;
        this.price_saled = price_saled;
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDeal_date() {
        return deal_date;
    }

    public void setDeal_date(String deal_date) {
        this.deal_date = deal_date;
    }

    public String getTittle_deal() {
        return tittle_deal;
    }

    public void setTittle_deal(String tittle_deal) {
        this.tittle_deal = tittle_deal;
    }

    public String getContent_deal() {
        return content_deal;
    }

    public void setContent_deal(String content_deal) {
        this.content_deal = content_deal;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public static int getCTYPE1() {
        return CTYPE1;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice_saled() {
        return price_saled;
    }

    public void setPrice_saled(String price_saled) {
        this.price_saled = price_saled;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
