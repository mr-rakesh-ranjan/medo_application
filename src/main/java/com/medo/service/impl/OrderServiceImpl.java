package com.medo.service.impl;

import com.medo.dao.CustomerDao;
import com.medo.dao.OrderDao;
import com.medo.dto.OrderDto;
import com.medo.entity.Customer;
import com.medo.entity.Order;
import com.medo.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderDto createOrder(OrderDto orderDto, String cust_id) {
//        System.out.println(orderDto);
        Order order = this.modelMapper.map(orderDto, Order.class);
        Customer customer = this.customerDao.getById(cust_id);
        order.setCustomer1(customer);
//        System.out.println(order);
        Order savedOrder  = this.orderDao.save(order);
        return this.modelMapper.map(savedOrder, OrderDto.class);
    }
}
