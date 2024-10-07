package ca.seneca.workshop2.models;

import java.util.ArrayList;

public class Pizza {
    private String size;
    private double price;
    private String crust;
    private String[] nmToppings;
    private String[] mToppings;

    private int nmSize;
    private int mSize;

    public Pizza(){

    }

    public Pizza(String size, double price, String crust, String[] nm, String[] m) {
        this.size = size;
        this.price = price;
        this.crust = crust;
        this.nmToppings = nm;
        this.mToppings = m;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String[] getToppings() {
        return nmToppings;
    }

    public void setToppings(String[] toppings) {
        this.mToppings = toppings;
    }

    public int getNmSize() {
        return nmToppings.length;
    }

    public int getMSize() {
        return mToppings.length;
    }

    public void addToNonMeat(String tName) {
        this.nmToppings[this.nmSize++] = tName;
    }

    public void addToMeat(String tName) {
        this.mToppings[this.mSize++] = tName;
    }

}
