package com.apodlatov.test.respak.data.repo;

import com.apodlatov.test.respak.data.models.option.ModelOptionValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelOptionValueRepository
        extends JpaRepository<ModelOptionValue, Long> {
}