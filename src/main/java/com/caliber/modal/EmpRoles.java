package com.caliber.modal;


import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "EMP_ROLES")
public class EmpRoles  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment in most databases
    private Integer id;

//    @NotNull
    @Column(length = 20, nullable = false, unique = true)
    private String roleName;
//    @NotNull
    @Column(length = 50, nullable = false)
    private String roleDesc;

    public EmpRoles() {
    }

    public EmpRoles(String roleName, String roleDesc) {
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }

    public EmpRoles(Integer id, String roleName, String roleDesc) {
        this.id = id;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmpRoles empRoles = (EmpRoles) o;
        return Objects.equals(id, empRoles.id) && Objects.equals(roleName, empRoles.roleName) && Objects.equals(roleDesc, empRoles.roleDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, roleDesc);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "EmpRoles{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
