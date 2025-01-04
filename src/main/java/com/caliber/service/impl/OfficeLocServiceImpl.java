package com.caliber.service.impl;

import com.caliber.modal.OfficeLocation;
import com.caliber.service.OfficeLocService;

import java.util.List;

public class OfficeLocServiceImpl implements OfficeLocService {
    @Override
    public OfficeLocation save(OfficeLocation location) {
        return null;
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
