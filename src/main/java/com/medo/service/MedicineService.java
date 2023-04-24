package com.medo.service;

import com.medo.dto.MedicineDto;
import com.medo.entity.Medicine;

import java.util.List;

public interface MedicineService {

    public Medicine createMedicine(MedicineDto medicineDto);
    public Medicine updateMedicine(MedicineDto medicineDto, Long medId);
    public List<Medicine> getMedicines();
    public Medicine getMedicine(long medId);
    public void deleteMedicine(long medId);
}
