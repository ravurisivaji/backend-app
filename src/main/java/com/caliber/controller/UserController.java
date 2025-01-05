package com.caliber.controller;


import com.caliber.modal.EmpRoles;
import com.caliber.modal.OfficeLocation;
import com.caliber.service.EmpRolesService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.Parameter;
import com.caliber.service.OfficeLocService;
import com.caliber.service.impl.OfficeLocServiceImpl;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private EmpRolesService empRolesService;

    @Autowired
    OfficeLocService officeLocService;

//    @Operation(summary = "Get a user by ID", description = "Retrieve a user by their unique ID.")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Successful retrieval"),
//            @ApiResponse(responseCode = "404", description = "User not found")
//    })
//    @GetMapping("/{id}")
//    public String getUserById(@Parameter(description = "ID of the user") @PathVariable String id) {
//        return "User with ID: " + id;
//    }

    @PostMapping(value = "/saveRole", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveRoles(@RequestBody EmpRoles empRoles){

        logger.info("***EmpRoles Save Method in controller with Param {} ***", empRoles.toString());

        if(ObjectUtils.isEmpty(empRoles)){
            logger.error("***EmpRoles is empty ***");
            logger.error(" role name : {} , Role Description {} " , empRoles.getRoleName(), empRoles.getRoleDesc());
            return new ResponseEntity<EmpRoles>(empRoles, HttpStatus.BAD_REQUEST);
        }

        //Check for duplicate roleName before calling save method

        if( empRolesService.existsByRoleName(empRoles.getRoleName())){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Roles with rolename " + empRoles.getRoleName() + " already exists")
                    ;
        }
        try {
            EmpRoles roles = empRolesService.saveRoles(empRoles);
            return new ResponseEntity<EmpRoles>(roles, HttpStatus.OK);
        }catch(DataIntegrityViolationException e){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Duplicate data error: " + e.getMessage())

                    ;
        }
    }

    // Fetch all users
    @GetMapping(value = "/allRoles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmpRoles> getAllUsers() {
        return empRolesService.findAll();
    }

    @PostMapping(value = "/saveOfficeLoc", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveOfficeAddress(@RequestBody OfficeLocation office){

        logger.info("Saving Office Address details :  " , office.toString());

        if( ObjectUtils.isEmpty(office)){
            logger.error(" One of the field in office object is empty {}", office.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        OfficeLocation officeLocation = officeLocService.saveOficeLocation(office);
        if( ObjectUtils.isEmpty(officeLocation)){
            return new ResponseEntity<>(officeLocation, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(officeLocation, HttpStatus.OK);
    }
}
