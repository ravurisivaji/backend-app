package com.caliber.service.impl;

import com.caliber.modal.OfficeLocation;
import com.caliber.repository.OfficeLocRepository;
import com.caliber.service.OfficeLocService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeLocServiceImpl implements OfficeLocService {

    private static final Logger logger = LogManager.getLogger(OfficeLocServiceImpl.class);

    @Autowired
    OfficeLocRepository officeLocRepository;

    @Override
    public OfficeLocation saveOficeLocation(OfficeLocation location) {
        logger.info("Service Layer save method {}" , location.toString());

        OfficeLocation officeLocation = new OfficeLocation();
        if(ObjectUtils.isEmpty(location)){
            logger.error("Location Object is null ");
            return officeLocation;
        }

        officeLocation = officeLocRepository.save(location);
        logger.info("Successfully saved office Location in DB {} ", officeLocation.toString());
        return officeLocation;
    }

    @Override
    public List<OfficeLocation> findAll() {
        return List.of();
    }

    @Override
    public Boolean existsByOfficeId(String id) {
        return null;
    }

    @Override
    public OfficeLocation getByLocationName(String name) {
        return null;
    }

    @Override
    public OfficeLocation getLocationById(String id) {
        return null;
    }
}
