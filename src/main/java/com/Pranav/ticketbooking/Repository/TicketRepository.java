package com.Pranav.ticketbooking.Repository;

import com.Pranav.ticketbooking.Model.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,Long> {

    Ticket findBySeatNo(int no);
}
