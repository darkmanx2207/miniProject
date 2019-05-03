package com.roma.hometestwork.service;

import com.roma.hometestwork.domain.Armchair;
import com.roma.hometestwork.repository.armchairRepository.ArmchairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ArmchairService {
    private final ArmchairRepository repository;

    @Autowired
    public ArmchairService(ArmchairRepository repository) {
        this.repository = repository;
    }

    public Long createArmchair(Armchair armchair) {
        return repository.create(armchair);
    }

    public List<Armchair> showAllArmchairs() {
        return repository.showAllArmchairs();
    }

    public Armchair findArmchairById(Long id) {
        return repository.findArmchairById(id)
                .orElseThrow(() -> new NoSuchElementException("Amrchair not found" + id));
    }

    @Transactional
    public void deleteArmchair(Long id) {
        repository.findArmchairById(id)
                .ifPresent(repository::deleteArmchair);
    }
}