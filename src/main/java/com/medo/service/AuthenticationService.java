package com.medo.service;

import com.medo.payload.AuthenticationRequest;
import com.medo.payload.AuthenticationResponse;
import com.medo.payload.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse registerCustomer(RegisterRequest request);
    AuthenticationResponse authenticateCustomer(AuthenticationRequest request);
}
