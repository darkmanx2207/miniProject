package com.roma.hometestwork.service;

import com.roma.hometestwork.domain.OfficeChair;
import com.roma.hometestwork.repository.officeChairRepository.OfficeChairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OfficeChairService {

    private final OfficeChairRepository repository;

    @Autowired
    public OfficeChairService(OfficeChairRepository repository) {
        this.repository = repository;
    }

    public Long createOfficeChair(OfficeChair officeChair) {
        return repository.create(officeChair);
    }

    public OfficeChair findOfficeChairById(Long id) {
        return repository.findOfficeChairById(id)
                .orElseThrow(() -> new NoSuchElementException("OfficeChair not found,id" + id));
    }

    public List<OfficeChair> showAllOfficeChairs() {
        return repository.showAllOfficeChairs();
    }

    @Transactional
    public void deleteOfficeChair(Long id) {
        repository.findOfficeChairById(id)
                .ifPresent(repository::deleteOfficeChair);

    }

}
