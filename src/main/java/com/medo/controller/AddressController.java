package com.medo.controller;

import com.medo.dto.AddressDto;
import com.medo.dto.CustomerDto;
import com.medo.entity.Address;
import com.medo.service.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @PostMapping("/add-address/{customerId}")
    public ResponseEntity<CustomerDto> addAddressToCustomer(@PathVariable("customerId") String customerId, @RequestBody AddressDto addressDto){
        CustomerDto customerDto = this.addressService.addAddressToCustomer(customerId, addressDto);
//        System.out.println("debugger at AATCC 2:" + customerDto);
        return ResponseEntity.ok(customerDto);
    }


    @GetMapping("/{customerId}/all-address")
    public ResponseEntity<List<Address>> getAllAddressesFromCustomer(@PathVariable("customerId") String customerId){
        return ResponseEntity.ok(this.addressService.getAllAddressFromCustomer(customerId));
    }

    @DeleteMapping("/{customerId}/delete/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable("customerId") String customerId, @PathVariable("addressId") String addressId){
        try {
            String s = this.addressService.deleteAddress(customerId,Long.parseLong(addressId));
            return ResponseEntity.ok(s);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update address
    @PutMapping("/{customerId}/update-address/{addressId}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable("customerId") String customerId, @PathVariable("addressId") String addressId, @RequestBody AddressDto addressDto){
        AddressDto addressDto1 = this.addressService.updateAddress(customerId, Long.parseLong(addressId), addressDto);
        return new ResponseEntity<>(addressDto1, HttpStatus.OK);
    }
}






