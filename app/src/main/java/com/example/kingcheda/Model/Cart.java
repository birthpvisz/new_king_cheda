package com.example.kingcheda.Model;

public class Cart
{
    private String pid, pname, date, discount, quantity, time, price;

    public Cart()
    {

    }

    public Cart(String pid, String pname, String date, String discount, String quantity, String time, String price) {
        this.pid = pid;
        this.pname = pname;
        this.date = date;
        this.discount = discount;
        this.quantity = quantity;
        this.time = time;
        this.price = price;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}