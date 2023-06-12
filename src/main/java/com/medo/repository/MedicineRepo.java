package com.medo.repository;

import com.medo.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository<Medicine, Long> {

    public Medicine getMedicineByMedId(Long medId);
}
