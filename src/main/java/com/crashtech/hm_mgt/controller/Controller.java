package com.crashtech.hm_mgt.controller;

import com.crashtech.hm_mgt.dto.ReservationRequest;
import com.crashtech.hm_mgt.model.Booking;
import com.crashtech.hm_mgt.model.Customer;
import com.crashtech.hm_mgt.model.Room;
import com.crashtech.hm_mgt.repository.BookingRepository;
import com.crashtech.hm_mgt.repository.CustomerRepository;
import com.crashtech.hm_mgt.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "api/htmgt")
public class Controller {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/greet")
    public String greet(){
        return "hello there!";
    }

    @PostMapping("/booking")
    public List<Booking> bookRoom(@RequestBody ReservationRequest request){

        customerRepository.save(request.getBooking().getCustomer());
         bookingRepository.save(request.getBooking());
         return bookingRepository.findAll();
    }

    @GetMapping("/getBookings")
    public List<Booking> getBookings(){
        return bookingRepository.findAll();
    }
    @GetMapping("/getRooms")
    public List<Room> getRooms(){
        return roomRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public Optional<?> deleteById(@PathVariable("id") int id){
        if(bookingRepository.existsById(id)){
            Optional<Booking> deletedBooking = bookingRepository.findById(id);
            bookingRepository.deleteById(id);
            return deletedBooking;
        }
        else{
            return Optional.of("record does not exist");
        }

    }

    @PutMapping("/edit/customer")
    public Optional<?> updateCustomer(@RequestParam("name") String name, @RequestParam("id") int id){
        if(customerRepository.existsById(id)) {
            Optional<Customer> customer = customerRepository.findById(id);
            customer.get().setName(name);
            customerRepository.save(customer.get());
            return Optional.of(customer);
        }
        else {
            return Optional.of("customer does not exist");
        }
    }

}
