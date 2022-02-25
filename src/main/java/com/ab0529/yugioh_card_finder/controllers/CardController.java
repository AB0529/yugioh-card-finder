package com.ab0529.yugioh_card_finder.controllers;

import com.ab0529.yugioh_card_finder.database.Card;
import com.ab0529.yugioh_card_finder.repositories.CardRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CardController {
    @Autowired
    private CardRepository cardRepository;

    @PostMapping("/add")
    public ResponseEntity addNewCard(@RequestBody Card c) {
        cardRepository.save(c);

        return new ResponseEntity<Card>(c, HttpStatus.CREATED);
    }

    @GetMapping("find")
    public ResponseEntity getCard(@RequestParam(name = "name") String name) {
        Optional<Card> c = cardRepository.findByName(name);

        if (c.isPresent()) {
            return new ResponseEntity<Card>(c.get(), HttpStatus.OK);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not found");
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Card> getAllCards() {
        return cardRepository.findAll();
    }
}
