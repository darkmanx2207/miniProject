package com.roma.hometestwork.repository.officeChairRepository;

import com.roma.hometestwork.domain.OfficeChair;

import java.util.List;
import java.util.Optional;

public interface OfficeChairRepository {

    Long create(OfficeChair officeChair);

    Optional<OfficeChair> findOfficeChairById(Long id);

    List<OfficeChair> showAllOfficeChairs();

    void deleteOfficeChair(OfficeChair officeChair);
}
