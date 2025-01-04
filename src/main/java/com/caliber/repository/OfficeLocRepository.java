package com.caliber.repository;

import com.caliber.modal.OfficeLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeLocRepository extends JpaRepository<OfficeLocation, Integer> {
}
