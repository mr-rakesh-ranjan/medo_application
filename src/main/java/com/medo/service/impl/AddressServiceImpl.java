package com.medo.service.impl;

import com.medo.dto.AddressDto;
import com.medo.dto.CustomerDto;
import com.medo.entity.Address;
import com.medo.entity.Customer;
import com.medo.repository.AddressRepo;
import com.medo.repository.CustomerRepo;
import com.medo.service.AddressService;
import com.medo.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CustomerDto addAddressToCustomer(String customerId, AddressDto addressDto) {
        Customer customer = this.customerRepo.findByCustomerId(customerId);
        Address address = this.modelMapper.map(addressDto, Address.class);
        address.setCustomer(customer);
        Address savedaddress = this.addressRepo.save(address);
        List<Address> addressList = customer.getAddresses();
        if(addressList.size() == 0){
            addressList.add(0, savedaddress);
        } else {
            addressList.add(addressList.size() - 1, savedaddress);
        }

        return CustomerDto.builder()
                .addresses(addressList)
                .email(customer.getCustomerId())
                .name(customer.getName())
                .customerId(customer.getCustomerId())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }

    @Override
    public List<Address> getAllAddressFromCustomer(String customerId) {
        Customer customer = this.customerRepo.findByCustomerId(customerId);
        List<Address> addressList = customer.getAddresses();
        return addressList;
    }

    @Override
    public String deleteAddress(String customerId, Long addressId) {
        String res = "";
        try{
            Address address = this.addressRepo.getAddressByAddressIdAndCustomer(addressId,customerId);
            this.addressRepo.delete(address);
            res = "your address is deleted";
        } catch (Exception e){
            e.printStackTrace();
            res = "your address is not deleted";
            System.out.println("not deleted");
        }
        return res;
    }

    @Override
    public AddressDto updateAddress(String customerId, Long addressId, AddressDto addressDto) {
        Address address = this.addressRepo.getAddressByAddressIdAndCustomer(addressId, customerId);
        address.setFlatNo(addressDto.getFlatNo());
        address.setLocality(addressDto.getLocality());
        address.setStreetName(addressDto.getStreetName());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setPincode(addressDto.getPincode());
        this.addressRepo.save(address);

        return AddressDto.builder()
                .flatNo(address.getFlatNo())
                .streetName(address.getStreetName())
                .locality(address.getLocality())
                .city(address.getCity())
                .state(address.getState())
                .pincode(address.getPincode())
                .build();
    }


}
