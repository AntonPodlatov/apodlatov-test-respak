package com.apodlatov.test.respak.data.repo;

import com.apodlatov.test.respak.data.models.TechnicsTypeData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TechnicsTypeDataRepository
        extends JpaRepository<TechnicsTypeData, Long> {

    @Query(value =
            "SELECT ttd FROM TechnicsTypeData ttd " +
            "LEFT JOIN FETCH ttd.technicsType tt " +
            "WHERE (:technicsTypeId IS NULL OR tt.id = :technicsTypeId)",

            countQuery =
                    "SELECT COUNT(ttd.id) FROM TechnicsTypeData ttd " +
                    "LEFT JOIN ttd.technicsType tt " +
                    "WHERE (:technicsTypeId IS NULL OR tt.id = :technicsTypeId)")
    Page<TechnicsTypeData> findPagedAndFilterByTypeIdIdNeeded(
            @Param("technicsTypeId") long technicsTypeId,
            Pageable pageable);
}