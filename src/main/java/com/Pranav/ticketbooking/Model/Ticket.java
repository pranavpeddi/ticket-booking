package com.Pranav.ticketbooking.Model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Tid;
    @Column(unique = true)
    private int seatNo;
    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    private Movie movie;

}
