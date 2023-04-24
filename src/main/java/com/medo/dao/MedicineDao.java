package com.medo.dao;

import com.medo.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicineDao extends JpaRepository<Medicine, Long> {

    public Medicine getMedicineByMedId(Long medId);
}
