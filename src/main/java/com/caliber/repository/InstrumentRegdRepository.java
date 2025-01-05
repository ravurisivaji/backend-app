package com.caliber.repository;

import com.caliber.modal.InstrumentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentRegdRepository extends JpaRepository<InstrumentRegistration, Integer> {
    @Query(value = "SELECT * FROM InstrumentRegistration i WHERE i.instId = ?1" , nativeQuery = true)
    InstrumentRegistration findByInstId(String id);

    @Query(value = "SELECT * FROM InstrumentRegistration i WHERE i.instInstalledAt = ?1" , nativeQuery = true)
    List<InstrumentRegistration> getInstrumentByInstInstalledAt(String location);

    @Query(value = "SELECT * FROM InstrumentRegistration i WHERE i.department = ?1" , nativeQuery = true)

    List<InstrumentRegistration> getInstrumentsByDepartments(String department);
}
