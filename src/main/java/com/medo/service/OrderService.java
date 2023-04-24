package com.medo.service;

import com.medo.dto.OrderDto;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto, String cust_id);
}
