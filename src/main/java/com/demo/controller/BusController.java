package com.demo.controller;

import com.demo.entity.Bus;
import com.demo.repository.BusRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/bus")
public class BusController {

    private BusRepository busRepository;

    public BusController(BusRepository busRepository) {
        this.busRepository = busRepository;
    }
    @PostMapping
    public ResponseEntity<Bus> addBus(@RequestBody Bus bus){
        Bus savedBus = busRepository.save(bus);
        return ResponseEntity.ok().body(savedBus);
    }
}
