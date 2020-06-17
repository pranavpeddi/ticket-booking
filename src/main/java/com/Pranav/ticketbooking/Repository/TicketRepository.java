package com.Pranav.ticketbooking.Repository;

import com.Pranav.ticketbooking.Model.Ticket;
import lombok.val;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,Long> {

    Ticket findBySeatNo(int no);

    @Query(value = "select seat_no" +
            " from Ticket where movie_m_id=?1",nativeQuery = true)
    List<Map<String,Object>> getTicketByMovie_MId(long movie_id);
}
