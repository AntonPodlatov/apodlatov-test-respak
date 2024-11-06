package com.apodlatov.test.respak.data.repo;

import com.apodlatov.test.respak.data.models.option.ModelOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelOptionRepository
        extends JpaRepository<ModelOption, Long> {
}