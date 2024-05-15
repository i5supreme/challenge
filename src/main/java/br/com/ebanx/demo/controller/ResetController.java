package br.com.ebanx.demo.controller;

import br.com.ebanx.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reset")
public class ResetController {

    @Autowired
    EventService eventService;

    @PostMapping
    public ResponseEntity<Void> reset() {
        eventService.reset();
        return ResponseEntity.ok().build();
    }

}
