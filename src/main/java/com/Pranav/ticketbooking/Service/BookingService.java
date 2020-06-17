package com.Pranav.ticketbooking.Service;

import com.Pranav.ticketbooking.Model.Customer;
import com.Pranav.ticketbooking.Model.Movie;
import com.Pranav.ticketbooking.Model.Ticket;
import com.Pranav.ticketbooking.Repository.CustomerRepository;
import com.Pranav.ticketbooking.Repository.MovieRepository;
import com.Pranav.ticketbooking.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BookingService {



    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TicketRepository ticketRepository;

 public List<Integer> seatlist=new ArrayList<>();

  public   void saveMovie(Movie movie)
    {
      movieRepository.save(movie);
    }

   public void bookTicket(String movieName,int seatNo,String name,String email)
    {


        Movie movie=movieRepository.findByMovieName(movieName);

        Ticket ticket = new Ticket();
            LocalDate date = LocalDate.now();
            ticket.setDate(date);
            LocalTime time = LocalTime.now();
            ticket.setTime(time);
            ticket.setSeatNo(seatNo);
            ticket.setMovie(movie);
            ticketRepository.save(ticket);
            Customer customer = new Customer();
            customer.setTicket(ticket);
            customer.setCustomerName(name);
            customer.setCustomerEmail(email);
            customerRepository.save(customer);

    }

   public void cancelTicket(String name)
    {
         Customer customer=customerRepository.findByCustomerName(name);
      //  Ticket ticket=ticketRepository.findByTid(customer.getTicket().getTid());
        Ticket ticket=ticketRepository.findBySeatNo(customer.getTicket().getSeatNo());


         customerRepository.delete(customer);
        ticketRepository.delete(ticket);
    }

    public  List<Ticket> bookedTickets(String movieName)
    {
        Movie movie=movieRepository.findByMovieName(movieName);

         return (List<Ticket>)movie.getTickets() ;
    }

    public Movie findMovie(String name)
    {
     return    movieRepository.findByMovieName(name);
    }

    public Customer findCustomer(String name)
    {
       return customerRepository.findByCustomerName(name);
    }

    public boolean checkIfBooked(int i)
    {
        List<Ticket> tickets=(List<Ticket>)ticketRepository.findAll();
        for(Ticket t1:tickets)
        {
            if(t1.getSeatNo()==i)
            {
                return false;
            }

        }
        return true;
    }

    public Integer ticketsBookedinNo(String movieName)
    {
        Movie movie=movieRepository.findByMovieName(movieName);
        return movie.getTickets().size();
    }

   public List<Map<String,Object>> getMovieSeatNos(String movieName)
   {
       Movie movie=movieRepository.findByMovieName(movieName);
       return ticketRepository.getTicketByMovie_MId(movie.getmId());
   }
}
