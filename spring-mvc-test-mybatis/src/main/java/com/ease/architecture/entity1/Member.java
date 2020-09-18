package com.ease.architecture.entity1;

public class Member {
    private  int id;
    private String mnane;
    private   String  phone;
    private  String  email;
    private  String adress;
    private  double  discountlevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMnane() {
        return mnane;
    }

    public void setMnane(String mnane) {
        this.mnane = mnane;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getDiscountlevel() {
        return discountlevel;
    }

    public void setDiscountlevel(double discountlevel) {
        this.discountlevel = discountlevel;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", mnane='" + mnane + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", adress='" + adress + '\'' +
                ", discountlevel=" + discountlevel +
                '}';
    }
}
