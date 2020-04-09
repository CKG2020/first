package com.example;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address", schema = "db1")
public class AddressEntity {
    private Integer id;
    private String street;
    private String city;
//    private String provice;
//    private String zipcode;
    private CustomerEntity customer;

@NotNull
    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer ID) {
        this.id = ID;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }


    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

//    @Basic
//    @Column(name = "provice")
//    public String getProvice() {
//        return provice;
//    }
//
//    public void setProvice(String provice) {
//        this.provice = provice;
//    }
//
//    @Basic
//    @Column(name = "zipcode")
//    public String getZipcode() {
//        return zipcode;
//    }
//
//    public void setZipcode(String zipcode) {
//        this.zipcode = zipcode;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return id== that.id &&
                Objects.equals(street, that.street) &&
                Objects.equals(city, that.city)
             ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, city);
    }
}
