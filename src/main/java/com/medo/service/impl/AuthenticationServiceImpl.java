package com.medo.service.impl;

import com.medo.dto.CustomerDto;
import com.medo.entity.Customer;
import com.medo.entity.Role;
import com.medo.entity.Token;
import com.medo.entity.TokenType;
import com.medo.payload.AuthenticationRequest;
import com.medo.payload.AuthenticationResponse;
import com.medo.payload.RegisterRequest;
import com.medo.repository.CustomerRepo;
import com.medo.repository.TokenRepo;
import com.medo.security.JwtService;
import com.medo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenRepo tokenRepo;

    @Override
    public AuthenticationResponse registerCustomer(RegisterRequest request) {
        var customer = Customer.builder()
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        var savedCustomer = this.customerRepo.save(customer);
        //todo generate token after the successfully signup
        var jwtToken = this.jwtService.generateToken(customer);
        savedCustomerToken(savedCustomer, jwtToken);
        CustomerDto customerDto = new CustomerDto(
                customer.getCustomerId(),
                customer.getName(),
                customer.getPhoneNumber(),
                customer.getPassword(),
                customer.getEmail(),
                customer.getAddresses()
        );
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .customer(customerDto)
                .build();
    }


    @Override
    public AuthenticationResponse authenticateCustomer(AuthenticationRequest request) {
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var customer = this.customerRepo.findByEmail(request.getEmail()).orElseThrow(
                () -> new UsernameNotFoundException("user not found")
        );
        //todo generate token after successfully login
        var jwtToken = this.jwtService.generateToken(customer);
        revokedAllCustomerToken(customer);
        savedCustomerToken(customer, jwtToken);
        CustomerDto customerDto = new CustomerDto(
                customer.getCustomerId(),
                customer.getName(),
                customer.getPhoneNumber(),
                customer.getPassword(),
                customer.getEmail(),
                customer.getAddresses()
        );
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .customer(customerDto)
                .build();
    }

    private void revokedAllCustomerToken(Customer customer){
        var validCustomerToken = this.tokenRepo.findAllValidTokensByCustomer(customer.getCustomerId());
        if(validCustomerToken.isEmpty()){
            return;
        }
        validCustomerToken.forEach(t -> {
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepo.saveAll(validCustomerToken);
    }

    private void savedCustomerToken(Customer customer, String jwtToken) {
        var token = Token.builder()
                .customer(customer)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();

        this.tokenRepo.save(token);
    }
}
