package com.caliber.service.impl;

import com.caliber.modal.EmpRoles;
import com.caliber.repository.EmpRolesRepository;
import com.caliber.service.EmpRolesService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpRolesServiceImpl implements EmpRolesService {

    private static final Logger logger = LogManager.getLogger(EmpRolesServiceImpl.class);

    @Autowired
    EmpRolesRepository roleRepo;

    @Override
    @Transactional(propagation= Propagation.REQUIRED, readOnly=false)
    public EmpRoles saveRoles(EmpRoles roles) {
        logger.info(" ***Roles Save Method with param {} *** ", roles.toString());

        if(ObjectUtils.isEmpty(roles)){
            logger.error(" ***Roles is empty ***");
            return null;
        }

        EmpRoles empRoles = roleRepo.save(roles);
        logger.info(" ***Successfully Inserted into DB: {}  *** ", empRoles.toString());
        return empRoles;
    }

    public List<EmpRoles> findAll(){

        logger.info(" List of all roles from DB ");

        List<EmpRoles> rolesList = roleRepo.findAll();

        if( rolesList.size() == 0 ){
            logger.info("No roles entries found in DB");
        }
        return rolesList;

    }

    @Override
    public Boolean existsByRoleName(String roleName) {
        logger.info("***Checking rolename in the DB {} ***" , roleName);
        Boolean isRoleExist = roleRepo.existsByRoleName(roleName);
        return isRoleExist;
    }
}
