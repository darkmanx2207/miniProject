package com.roma.hometestwork.service;

import com.roma.hometestwork.domain.Tabouret;
import com.roma.hometestwork.repository.tabouretRepository.TabouretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TabouretService {

    private final TabouretRepository repository;

    @Autowired
    public TabouretService(TabouretRepository repository) {
        this.repository = repository;
    }

    public Long createTabouret(Tabouret tabouret) {
        return repository.create(tabouret);
    }

    public Tabouret findTabouretById(Long id) {
        return repository.findTabouretById(id)
                .orElseThrow(() -> new NoSuchElementException("Tabouret not found, id: " + id));
    }

    public List<Tabouret> showAllTabourets() {
        return repository.showAllTabourets();
    }

    @Transactional
    public void deleteTabouret(Long id) {
        repository.findTabouretById(id)
                .ifPresent(repository::deleteTabouret);
    }
}