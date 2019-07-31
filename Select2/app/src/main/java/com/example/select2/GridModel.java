package com.example.select2;

public class GridModel {
    int img_wine;
    boolean isFreeship,isHot;
    String name,content,price;

    public GridModel(int img_wine, String name, String content, String price, boolean isFreeship, boolean isHot) {
        this.img_wine = img_wine;
        this.isFreeship = isFreeship;
        this.isHot = isHot;
        this.name = name;
        this.content = content;
        this.price = price;
    }

    public int getImg_wine() {
        return img_wine;
    }

    public void setImg_wine(int img_wine) {
        this.img_wine = img_wine;
    }

    public boolean isFreeship() {
        return isFreeship;
    }

    public void setFreeship(boolean freeship) {
        isFreeship = freeship;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
