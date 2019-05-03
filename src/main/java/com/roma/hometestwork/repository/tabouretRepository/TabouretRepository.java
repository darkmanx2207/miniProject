package com.roma.hometestwork.repository.tabouretRepository;

import com.roma.hometestwork.domain.Tabouret;

import java.util.List;
import java.util.Optional;

public interface TabouretRepository {

    Long create(Tabouret tabouret);

    Optional<Tabouret> findTabouretById(Long id);

    List<Tabouret> showAllTabourets();

    void deleteTabouret(Tabouret tabouret);
}