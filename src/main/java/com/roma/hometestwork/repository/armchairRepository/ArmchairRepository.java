package com.roma.hometestwork.repository.armchairRepository;

import com.roma.hometestwork.domain.Armchair;

import java.util.List;
import java.util.Optional;

public interface ArmchairRepository {

    Long create(Armchair armchair);

    Optional<Armchair> findArmchairById(Long id);

    List<Armchair> showAllArmchairs();

    void deleteArmchair(Armchair armchair);
}