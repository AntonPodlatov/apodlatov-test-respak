package com.apodlatov.test.respak.service;

import com.apodlatov.test.respak.data.models.TechnicsType;
import com.apodlatov.test.respak.data.models.TechnicsTypeData;
import com.apodlatov.test.respak.data.repo.TechnicsTypeDataRepository;
import com.apodlatov.test.respak.service.api.TechnicsTypesDataService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class DefaultTechnicsTypesDataService implements TechnicsTypesDataService {
    private final TechnicsTypeDataRepository technicsTypeDataRepository;
    private final EntityManager entityManager;

    public DefaultTechnicsTypesDataService(
            EntityManager entityManager,
            TechnicsTypeDataRepository technicsTypeDataRepository) {
        this.technicsTypeDataRepository = technicsTypeDataRepository;
        this.entityManager = entityManager;
    }

    @Override
    public TechnicsTypeData addTechnicsTypeData(
            Long technicsTypeId, String manufacturerName, String manufactureCountry,
            boolean installmentsAvailable, boolean onlineOrderAvailable) {

        TechnicsTypeData technicsTypeData = new TechnicsTypeData();
        technicsTypeData.setTechnicsType(entityManager.getReference(TechnicsType.class, technicsTypeId));
        technicsTypeData.setManufacturerName(manufacturerName);
        technicsTypeData.setManufactureCountry(manufactureCountry);
        technicsTypeData.setInstallmentsAvailable(installmentsAvailable);
        technicsTypeData.setOnlineOrderAvailable(onlineOrderAvailable);

        return technicsTypeDataRepository.save(technicsTypeData);
    }
}
