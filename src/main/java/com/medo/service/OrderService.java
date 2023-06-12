package com.medo.service;

import com.medo.dto.OrderDto;
import com.medo.entity.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(OrderDto orderDto, String customerId);

    void updateOrder(OrderDto orderDto, String customerId, Long orderId);

    List<Order> getAllOrders(String CustomerId);

}
