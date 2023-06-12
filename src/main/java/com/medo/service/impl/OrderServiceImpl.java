package com.medo.service.impl;

import com.medo.repository.CustomerRepo;
import com.medo.repository.OrderRepo;
import com.medo.dto.OrderDto;
import com.medo.entity.Order;
import com.medo.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Order createOrder(OrderDto orderDto, String cust_id) {
        return null;
    }

    @Override
    public void updateOrder(OrderDto orderDto, String customerId, Long orderId) {

    }

    @Override
    public List<Order> getAllOrders(String CustomerId) {
        return null;
    }
}
