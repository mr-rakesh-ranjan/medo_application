package com.medo.service;

import com.medo.dto.OrderDto;
import com.medo.entity.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(OrderDto orderDto, String customerId);
    List<Order> getAllOrders(String CustomerId);

}
