package com.crashtech.hm_mgt.model;

import jakarta.persistence.*;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @Column(name="customer_id")
    private Integer customer_id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @OneToOne(mappedBy = "customer")
    private Booking booking;
    public Customer() {
    }

    public Customer(Integer customer_id, String name, String address) {
        this.customer_id = customer_id;
        this.name = name;
        this.address = address;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
