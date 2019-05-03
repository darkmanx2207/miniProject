package com.roma.hometestwork.controller;

import com.roma.hometestwork.domain.Chair;
import com.roma.hometestwork.service.ChairService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/chairs")
public class ChairController {

    private final ChairService service;

    public ChairController(ChairService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Validated({Chair.Create.class}) @RequestBody Chair chair,
                                       UriComponentsBuilder builder) {
        Long id = service.createChair(chair);
        return ResponseEntity.created(builder.path("/chairs/{id}").buildAndExpand(id).toUri()).build();
    }

    @GetMapping
    public List<Chair> showAllChairs() {
        return service.showAllChairs();
    }

    @GetMapping("/{id}")
    public Chair findChairById(@PathVariable("id") Long id) {
        return service.findChairById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteChair(@PathVariable Long id) {
        service.deleteChair(id);
    }
}