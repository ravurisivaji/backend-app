package com.caliber.modal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "INSTRUMENT_REGISTRATION")
public class InstrumentRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "INST_CATEGORY", nullable = false, length = 100)
    private String instCategory;
    @Column(name = "INST_NAME", nullable = false, length = 100)
    private String instName;
    @Column(name = "INST_ID", nullable = false, length = 25)
    private String instId;
    @Column(name = "INST_MFG", nullable = false, length = 100)
    private String instMake;
    @Column(name = "INST_MODEL", nullable = false, length = 100)
    private String instModel;
    @Column(name = "INST_SUPPLIED_BY", nullable = false, length = 100)
    private String instSuppliedBy;
    @Column(name = "INST_REMARKS", nullable = false, length = 100)
    private String instRemarks;
    @Column(name = "INST_SERIAL_NO", nullable = false, length = 100)
    private String instSerialNo;
    @Column(name = "INST_INSTALLED_LOCATION", nullable = false, length = 100)
    private String instInstalledAt;
    @Column(name = "DEPARTMENT", nullable = false, length = 100)
    private String department;
    @CreatedDate
    @Column(name = "INST_INSTALLED_ON", nullable = false, length = 100, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date instInstalledOn;
    @Column(name = "INST_WARRANTY_EXPIRE_ON", nullable = false, length = 100, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date instWarrantyExpireOn;
    @Column(name = "INST_ACTIVE", nullable = false, length = 1)
    private Boolean instActive;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentRegistration that = (InstrumentRegistration) o;
        return Objects.equals(id, that.id) && Objects.equals(instCategory, that.instCategory) && Objects.equals(instName, that.instName) && Objects.equals(instId, that.instId) && Objects.equals(instMake, that.instMake) && Objects.equals(instModel, that.instModel) && Objects.equals(instSuppliedBy, that.instSuppliedBy) && Objects.equals(instRemarks, that.instRemarks) && Objects.equals(instSerialNo, that.instSerialNo) && Objects.equals(instInstalledAt, that.instInstalledAt) && Objects.equals(department, that.department) && Objects.equals(instInstalledOn, that.instInstalledOn) && Objects.equals(instWarrantyExpireOn, that.instWarrantyExpireOn) && Objects.equals(instActive, that.instActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instCategory, instName, instId, instMake, instModel, instSuppliedBy, instRemarks, instSerialNo, instInstalledAt, department, instInstalledOn, instWarrantyExpireOn, instActive);
    }

    @Override
    public String toString() {
        return "InstrumentRegistration{" +
                "id=" + id +
                ", instCategory='" + instCategory + '\'' +
                ", instName='" + instName + '\'' +
                ", instId='" + instId + '\'' +
                ", instMake='" + instMake + '\'' +
                ", instModel='" + instModel + '\'' +
                ", instSuppliedBy='" + instSuppliedBy + '\'' +
                ", instRemarks='" + instRemarks + '\'' +
                ", instSerialNo='" + instSerialNo + '\'' +
                ", instInstalledAt='" + instInstalledAt + '\'' +
                ", department='" + department + '\'' +
                ", instInstalledOn=" + instInstalledOn +
                ", instWarrantyExpireOn=" + instWarrantyExpireOn +
                ", instActive=" + instActive +
                '}';
    }

    public InstrumentRegistration(String instCategory, String instName, String instId, String instMake, String instModel, String instSuppliedBy, String instRemarks, String instSerialNo, String instInstalledAt, String department, Date instInstalledOn, Date instWarrantyExpireOn, Boolean instActive) {
        this.instCategory = instCategory;
        this.instName = instName;
        this.instId = instId;
        this.instMake = instMake;
        this.instModel = instModel;
        this.instSuppliedBy = instSuppliedBy;
        this.instRemarks = instRemarks;
        this.instSerialNo = instSerialNo;
        this.instInstalledAt = instInstalledAt;
        this.department = department;
        this.instInstalledOn = instInstalledOn;
        this.instWarrantyExpireOn = instWarrantyExpireOn;
        this.instActive = instActive;
    }
}
