package com.apodlatov.test.respak.data.repo;

import com.apodlatov.test.respak.data.models.TechnicsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TechnicsModelRepository
        extends JpaRepository<TechnicsModel, Long> {

    @Query("SELECT tm FROM TechnicsModel tm " +
            "LEFT JOIN FETCH tm.color " +
            "LEFT JOIN FETCH tm.modelSize " +
            "LEFT JOIN FETCH tm.modelOptionsValues mov " +
            "LEFT JOIN FETCH mov.modelOption " +
            "WHERE tm.id in :ids")
    List<TechnicsModel> fetchTechnicsModelsByIdsWithoutTypeData(@Param("ids") List<Long> ids);


    @Query("SELECT tm FROM TechnicsModel tm " +
            "LEFT JOIN FETCH tm.color c " +
            "LEFT JOIN FETCH tm.modelSize " +
            "LEFT JOIN FETCH tm.technicsTypeData ttd " +
            "LEFT JOIN FETCH ttd.technicsType tt " +
            "LEFT JOIN FETCH tm.modelOptionsValues mov " +
            "LEFT JOIN FETCH mov.modelOption " +
            "WHERE (:technicsModelNameTerm IS NULL OR :technicsModelNameTerm = '' OR " +
                    "LOWER(tm.name) LIKE LOWER(CONCAT('%', :technicsModelNameTerm, '%'))" +
            ") AND (:colorId IS NULL OR c.id = :colorId) " +
            "AND (:technicsTypeId IS NULL OR tt.id = :technicsTypeId) " +
            "AND (:priceFrom IS NULL OR tm.price >= :priceFrom) " +
            "AND (:priceTo IS NULL OR tm.price <= :priceTo)")
    List<TechnicsModel> search(
            @Param("technicsModelNameTerm") String technicsModelNameTerm,
            @Param("colorId") Long colorId,
            @Param("technicsTypeId") Long technicsTypeId,
            @Param("priceFrom") BigDecimal priceFrom,
            @Param("priceTo") BigDecimal priceTo);
}