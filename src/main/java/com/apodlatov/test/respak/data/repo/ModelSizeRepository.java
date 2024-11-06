package com.apodlatov.test.respak.data.repo;

import com.apodlatov.test.respak.data.models.side.data.ModelSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelSizeRepository extends JpaRepository <ModelSize, Long> {
}