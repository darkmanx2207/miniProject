package com.roma.hometestwork.repository.chairRepository;

import com.roma.hometestwork.domain.Chair;

import java.util.List;
import java.util.Optional;

public interface ChairRepository {

    Long create(Chair chair);

    Optional<Chair> findChairById(Long id);

    List<Chair> showAllChairs();

    void deleteChair(Chair chair);
}