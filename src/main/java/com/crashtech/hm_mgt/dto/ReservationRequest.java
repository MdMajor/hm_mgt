package com.crashtech.hm_mgt.dto;

import com.crashtech.hm_mgt.model.Booking;

public class ReservationRequest {
    private Booking booking;

    public ReservationRequest() {
    }

    public ReservationRequest(Booking booking) {
        this.booking = booking;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "ReservationRequest{" +
                "booking=" + booking +
                ", customer=" +
                '}';
    }
}
