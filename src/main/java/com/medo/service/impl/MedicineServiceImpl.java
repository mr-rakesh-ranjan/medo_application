package com.medo.service.impl;

import com.medo.dao.MedicineDao;
import com.medo.dto.MedicineDto;
import com.medo.entity.Medicine;
import com.medo.service.MedicineService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineDao medicineDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Medicine createMedicine(MedicineDto medicineDto) {
        System.out.println(medicineDto);
        Medicine medicine = this.modelMapper.map(medicineDto, Medicine.class);
        Medicine createdMedicine = this.medicineDao.save(medicine);
        return createdMedicine;
    }

    @Override
    public Medicine updateMedicine(MedicineDto medicineDto, Long medId) {
        Medicine medicine;
        medicine = this.medicineDao.getMedicineByMedId(medId);
        System.out.println(medicine + "this is med by dao layer");
        medicine = this.modelMapper.map(medicineDto, Medicine.class);
        medicine.setMedId(medId);
        System.out.println("med by service layer " + medicine);
        return this.medicineDao.save(medicine);
    }

    @Override
    public List<Medicine> getMedicines() {
        return this.medicineDao.findAll();
    }

    @Override
    public Medicine getMedicine(long medId) {
        return this.medicineDao.getMedicineByMedId(medId);
    }

    @Override
    public void deleteMedicine(long medId) {
        Medicine medicine = this.medicineDao.getMedicineByMedId(medId);
        this.medicineDao.delete(medicine);
    }
}
