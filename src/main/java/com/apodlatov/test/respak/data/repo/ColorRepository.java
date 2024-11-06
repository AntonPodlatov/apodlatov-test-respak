package com.apodlatov.test.respak.data.repo;

import com.apodlatov.test.respak.data.models.side.data.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository <Color, Long> {
}