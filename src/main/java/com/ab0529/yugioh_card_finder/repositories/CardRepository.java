package com.ab0529.yugioh_card_finder.repositories;

import com.ab0529.yugioh_card_finder.database.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CardRepository extends CrudRepository<Card, Integer> {
    @Query(value="SELECT * FROM Cards ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Card getRandomItem();

    Optional<Card> findByName(String name);

    Optional<Card> findByid(@Param("id") int id);

//    @Query(value = "SELECT c FROM Cards c WHERE c.id=:id", nativeQuery = true)
//    Optional<Card> findByCardID(@Param("id") int id);
}
