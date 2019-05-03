package com.roma.hometestwork.controller;

import com.roma.hometestwork.domain.Tabouret;
import com.roma.hometestwork.service.TabouretService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/tabourets")
public class TabouretController {

    private final TabouretService service;

    public TabouretController(TabouretService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Validated({Tabouret.Create.class}) @RequestBody Tabouret tabouret,
                                       UriComponentsBuilder builder) {
        Long id = service.createTabouret(tabouret);
        return ResponseEntity.created(builder.path("/tabourets/{id}").buildAndExpand(id).toUri()).build();
    }

    @GetMapping("/{id}")
    public Tabouret findTabouretById(@PathVariable("id") Long id) {
        return service.findTabouretById(id);
    }

    @GetMapping
    public List<Tabouret> showAllTabourets() {
        return service.showAllTabourets();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTabouret(@PathVariable Long id) {
        service.deleteTabouret(id);
    }
}