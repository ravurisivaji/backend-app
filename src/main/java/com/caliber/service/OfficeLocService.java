package com.caliber.service;

import com.caliber.modal.EmpRoles;
import com.caliber.modal.OfficeLocation;

import java.util.List;

public interface OfficeLocService {

    public OfficeLocation saveOficeLocation(OfficeLocation location);
    public List<OfficeLocation> findAll();

    public Boolean existsByOfficeId(String id);

    public OfficeLocation getByLocationName(String name);

    public OfficeLocation getLocationById(String id);

}
