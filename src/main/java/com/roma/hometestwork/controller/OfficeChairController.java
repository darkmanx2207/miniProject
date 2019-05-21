package com.roma.hometestwork.controller;

import com.roma.hometestwork.domain.OfficeChair;
import com.roma.hometestwork.service.OfficeChairService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/officechairs")
public class OfficeChairController {

    private final OfficeChairService service;

    public OfficeChairController(OfficeChairService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Validated({OfficeChair.Create.class}) @RequestBody OfficeChair officeChair,
                                       UriComponentsBuilder builder) {
        Long id = service.createOfficeChair(officeChair);
        return ResponseEntity.created(builder.path("/officechairs/{id}").buildAndExpand(id).toUri()).build();
    }

    @GetMapping("/{id}")
    public OfficeChair findOfficeChairById(@PathVariable("id") Long id) {
        return service.findOfficeChairById(id);
    }

    @GetMapping
    public List<OfficeChair> showAllOfficeChairs() {
        return service.showAllOfficeChairs();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOfficeChair(@PathVariable Long id) {
        service.deleteOfficeChair(id);
    }
}
