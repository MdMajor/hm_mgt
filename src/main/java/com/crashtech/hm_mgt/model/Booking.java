package com.crashtech.hm_mgt.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="reservation_date")
    private Date reservation_date;

    @Column(name="date_in")
    private Date date_in;

    @Column(name="date_out")
    private Date date_out;

    @OneToOne
    @JoinColumn(name="c_id")
    private Customer customer;

//    @OneToMany(targetEntity = Room.class,cascade = CascadeType.ALL)
//    @JoinColumn(name="r_id",referencedColumnName = "id")
    @OneToMany(targetEntity = Room.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "b_id_fk",referencedColumnName = "id")
    private List<Room> room;

    public Booking() {
    }

    public Booking(Integer id, Date reservation_date, Date date_in, Date date_out, Customer customer, List<Room> room) {
        this.id = id;
        this.reservation_date = reservation_date;
        this.date_in = date_in;
        this.date_out = date_out;
        this.customer = customer;
        this.room = room;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    public Date getDate_in() {
        return date_in;
    }

    public void setDate_in(Date date_in) {
        this.date_in = date_in;
    }

    public Date getDate_out() {
        return date_out;
    }

    public void setDate_out(Date date_out) {
        this.date_out = date_out;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> rooms) {
        this.room = rooms;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", reservation_date=" + reservation_date +
                ", date_in=" + date_in +
                ", date_out=" + date_out +
                ", customer=" + customer +
                ", rooms=" + room +
                '}';
    }
}
