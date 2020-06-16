package com.Pranav.ticketbooking.Repository;

import com.Pranav.ticketbooking.Model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Long> {

    Movie  findByMovieName(String name);

}
