package com.crashtech.hm_mgt.model;

import jakarta.persistence.*;

@Entity
@Table(name="room")
public class Room {
    @Id
    @Column(name="room_id")
    private Integer room_id;

    @Column(name = "description")
    private String description;

    @Column(name="price")
    private Integer price;

    public Room() {
    }

    public Room(Integer room_id, String description, Integer price) {
        this.room_id = room_id;
        this.description = description;
        this.price = price;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
