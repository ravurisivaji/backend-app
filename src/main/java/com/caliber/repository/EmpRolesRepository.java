package com.caliber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.caliber.modal.EmpRoles;

@Repository
public interface EmpRolesRepository extends JpaRepository<EmpRoles, Integer> {
    boolean existsByRoleName(String roleName);
}
