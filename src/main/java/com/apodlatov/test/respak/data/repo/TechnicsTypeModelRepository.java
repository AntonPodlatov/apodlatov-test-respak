package com.apodlatov.test.respak.data.repo;

import com.apodlatov.test.respak.data.models.TechnicsTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicsTypeModelRepository
        extends JpaRepository<TechnicsTypeModel, Long> {
}