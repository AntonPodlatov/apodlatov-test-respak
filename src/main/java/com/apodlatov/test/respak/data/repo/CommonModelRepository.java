package com.apodlatov.test.respak.data.repo;

import com.apodlatov.test.respak.data.models.TechnicsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonModelRepository
        extends JpaRepository<TechnicsModel, Long> {
}