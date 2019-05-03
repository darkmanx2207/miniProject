package com.roma.hometestwork.controller;

import com.roma.hometestwork.domain.Armchair;
import com.roma.hometestwork.service.ArmchairService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/armchairs")
public class ArmchairController {

    private final ArmchairService service;

    public ArmchairController(ArmchairService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Validated({Armchair.Create.class}) @RequestBody Armchair armchair,
                                       UriComponentsBuilder builder) {
        Long id = service.createArmchair(armchair);
        return ResponseEntity.created(builder.path("/armchairs/{id}").buildAndExpand(id).toUri()).build();
    }

    @GetMapping
    public List<Armchair> showAllArmchairs() {
        return service.showAllArmchairs();
    }

    @GetMapping("/{id}")
    public Armchair findArmchairById(@PathVariable("id") Long id) {
        return service.findArmchairById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArmchair(@PathVariable Long id) {
        service.deleteArmchair(id);
    }
}