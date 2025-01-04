package com.caliber.service;

import com.caliber.modal.EmpRoles;

import java.util.List;

public interface EmpRolesService {

    public EmpRoles saveRoles(EmpRoles roles);

    public List<EmpRoles> findAll();

    public Boolean existsByRoleName(String roleName);
}
