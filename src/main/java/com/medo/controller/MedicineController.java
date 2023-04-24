package com.medo.controller;

import com.medo.dto.MedicineDto;
import com.medo.entity.Medicine;
import com.medo.service.impl.MedicineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineServiceImpl medicineService;

    @PostMapping("/create")
    public Medicine createMedicine(@RequestBody MedicineDto medicineDto){
        return this.medicineService.createMedicine(medicineDto);
    }

    @PutMapping("{medId}")
    public Medicine updateMedicine(@RequestBody MedicineDto medicineDto, @PathVariable Long medId){
        return this.medicineService.updateMedicine(medicineDto, medId);
    }

    @GetMapping("/all")
    public List<Medicine> getAllMedicine(){
        return this.medicineService.getMedicines();
    }

    @GetMapping("/{medId}")
    public Medicine getMedicineById(@PathVariable Long medId){
        return this.medicineService.getMedicine(medId);
    }

    @DeleteMapping("/{medId}")
    public ResponseEntity<HttpStatus> deleteMedicine(@PathVariable long medId){
        try{
            this.medicineService.deleteMedicine(medId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
