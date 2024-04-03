package com.project.cr.controller;

import com.project.cr.model.Carta;
import com.project.cr.service.CartaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CartaController {

    private final CartaService cartaService;
    public CartaController(CartaService cartaService) {this.cartaService = cartaService;}

    @GetMapping("/all")
    public ResponseEntity<?> findAllCards(){
        return new ResponseEntity<>(this.cartaService.findAll(), HttpStatus.OK);
    }

    //method for filter cards with type
    @GetMapping("/{tipo}")
    public ResponseEntity<?> findCardsByType(@PathVariable String tipo){
        //recurso cards
        List<Carta> cardsList = cartaService.findAll();
        //filter cards
        List<Carta> filterCards = cardsList.stream()
                .filter(card -> card.getTipo().equals(tipo))
                .toList();
        return new ResponseEntity<>(filterCards, HttpStatus.OK);
    }

    @GetMapping("/search/{palabra}")
    public ResponseEntity<?>search(@PathVariable String palabra){
       List<Carta> searchCards = cartaService.search(palabra);
       return new ResponseEntity<>(searchCards, HttpStatus.OK);
    }
}
