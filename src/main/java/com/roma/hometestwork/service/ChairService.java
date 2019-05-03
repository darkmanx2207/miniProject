package com.roma.hometestwork.service;

import com.roma.hometestwork.domain.Chair;
import com.roma.hometestwork.repository.chairRepository.ChairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ChairService {

    private final ChairRepository repository;

    @Autowired
    public ChairService(ChairRepository repository) {
        this.repository = repository;
    }

    public Long createChair(Chair chair) {
        return repository.create(chair);
    }

    public Chair findChairById(Long id) {
        return repository.findChairById(id)
                .orElseThrow(() -> new NoSuchElementException("Chair not found, id: " + id));
    }

    public List<Chair> showAllChairs() {
        return repository.showAllChairs();
    }

    @Transactional
    public void deleteChair(Long id) {
        repository.findChairById(id)
                .ifPresent(repository::deleteChair);
    }
}