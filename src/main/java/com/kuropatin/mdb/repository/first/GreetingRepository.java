package com.kuropatin.mdb.repository.first;

import com.kuropatin.mdb.model.first.Greeting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {

    @Query(value = "SELECT * FROM greetings ORDER BY random() LIMIT 1", nativeQuery = true)
    Optional<Greeting> randomGreeting();
}