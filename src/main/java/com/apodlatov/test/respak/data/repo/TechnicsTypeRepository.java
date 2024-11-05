package com.apodlatov.test.respak.data.repo;

import com.apodlatov.test.respak.data.models.TechnicsType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicsTypeRepository
        extends JpaRepository<TechnicsType, Long> {
}