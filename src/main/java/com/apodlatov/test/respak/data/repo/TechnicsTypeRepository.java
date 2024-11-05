package com.apodlatov.test.respak.data.repo;

import com.apodlatov.test.respak.data.models.TechnicsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TechnicsTypeRepository
        extends JpaRepository<TechnicsType, Long> {

    @Query("SELECT ttm FROM TechnicsType ttm " +
            "LEFT JOIN FETCH ttm.technicsTypeModels " +
            "WHERE ttm.id IN :ids"
    )
    List<TechnicsType> findAllById(
             @Param("ids") List<Long> ids);
}