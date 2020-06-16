package com.Pranav.ticketbooking.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Cid;
 @Column(unique = true)
    private String customerName;
    @Column(unique = true)
    private String customerEmail;

    @OneToOne
    private Ticket ticket;


}
