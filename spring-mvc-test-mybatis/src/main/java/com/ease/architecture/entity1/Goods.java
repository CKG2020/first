package com.ease.architecture.entity1;

public class Goods {
    private  String  productID;
    private  String  productname;
    private  int price;
    private String    infor;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }


    @Override
    public String toString() {
        return "Goods{" +
                "productID='" + productID + '\'' +
                ", productname='" + productname + '\'' +
                ", price=" + price +
                ", infor='" + infor + '\'' +
                '}';
    }
}
