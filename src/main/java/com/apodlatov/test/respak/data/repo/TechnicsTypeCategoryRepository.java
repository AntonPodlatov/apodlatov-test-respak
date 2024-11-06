package com.apodlatov.test.respak.data.repo;

import com.apodlatov.test.respak.data.models.side.data.categories.TechnicsTypeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicsTypeCategoryRepository
        extends JpaRepository<TechnicsTypeCategory, Long> {
}