package com.phong.product.model;

public class Product {
    private int id;
    private String name;
    private String type;
    private double price;
    private int inventory;
    private String img;
    private int hsd;
    private String img1;
    private String img2;
    private String img3;
    private String trademark;
    private String madeIn;
    private String volume;
    private String using;
    private String folder;

    public Product() {
    }

    public Product(String name, String type, double price, int inventory, String img) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.inventory = inventory;
        this.img = img;
    }

    public Product(int id, String name, String type, double price, int inventory, String img) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.inventory = inventory;
        this.img = img;
    }

    public Product(String name, String type, double price, int hsd, String img1, String img2, String img3, String trademark, String madeIn, String volume, String using, String folder) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.hsd = hsd;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.trademark = trademark;
        this.madeIn = madeIn;
        this.volume = volume;
        this.using = using;
        this.folder = folder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getHsd() {
        return hsd;
    }

    public void setHsd(int hsd) {
        this.hsd = hsd;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getUsing() {
        return using;
    }

    public void setUsing(String using) {
        this.using = using;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}
