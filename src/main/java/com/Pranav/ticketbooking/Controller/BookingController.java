package com.Pranav.ticketbooking.Controller;

import com.Pranav.ticketbooking.Model.Customer;
import com.Pranav.ticketbooking.Model.Movie;
import com.Pranav.ticketbooking.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/saveMovie")
    public ResponseEntity<String> saveMovie(@RequestBody Movie movie)
    {
          bookingService.saveMovie(movie);
          return  new ResponseEntity<String>("movie is added", HttpStatus.OK);
    }

    @PostMapping("/bookticket/{moviename}/{seatNo}/{email}/{name}")
    public ResponseEntity<String> bookTicket(@RequestParam String moviename,@RequestParam int seatNo,
                                             @RequestParam  String email,@RequestParam String name)
    {
        Optional<Movie> checkMovie= Optional.ofNullable(bookingService.findMovie(moviename));
       if(!checkMovie.isPresent())
       {
           return new ResponseEntity<>("movie is not available at this time",HttpStatus.BAD_REQUEST);
       }

       else {
         if(!bookingService.checkIfBooked(seatNo))
         {
            return new ResponseEntity<>("seat no u choose is already booked,please choose another",HttpStatus.BAD_REQUEST);
         }
         if(bookingService.ticketsBookedinNo(moviename)>5)
           {
               return new ResponseEntity<>("sorry its HouseFull",HttpStatus.BAD_REQUEST);
           }

           bookingService.bookTicket(moviename,seatNo, name, email);
           return new ResponseEntity<String>("ticket is Booked", HttpStatus.OK);

       }
    }


    @DeleteMapping("/tickets/cancelTicket/{name}")
    public ResponseEntity<String> cancelTicket(@RequestParam String name)
    {
       Optional<Customer> checkCustomer= Optional.ofNullable(bookingService.findCustomer(name));
       if(checkCustomer.isPresent())
       {
             bookingService.cancelTicket(name);
             return new ResponseEntity<String>("ticket is cancelled",HttpStatus.OK);
       }
       else
       {
           return new ResponseEntity<String>("ticket is never booked", HttpStatus.BAD_REQUEST);
       }

    }

    @GetMapping("/movie/getTickets/{movieName}")
    public ResponseEntity<?> getTicketsofMovie(@RequestParam String movieName)
    {
          return new ResponseEntity<>(bookingService.bookedTickets(movieName),HttpStatus.OK);
    }
}
