package com.medo.service.impl;

import com.medo.entity.Customer;
import com.medo.entity.Medicine;
import com.medo.entity.OrderItems;
import com.medo.repository.CustomerRepo;
import com.medo.repository.OrderItemsRepo;
import com.medo.repository.OrderRepo;
import com.medo.dto.OrderDto;
import com.medo.entity.Order;
import com.medo.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderItemsRepo orderItemsRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Order createOrder(OrderDto orderDto, String cust_id) {
        Customer customer = this.customerRepo.findByCustomerId(cust_id);
        System.out.println(customer.getEmail());
        try {
            Order order = new Order();
//            order = this.orderRepo.saveAndFlush(order);
            List<OrderItems>  orderItems = orderDto.getOrderItems();
            for(int i = 0; i < orderItems.size(); i++){
                OrderItems temp = orderItems.get(i);
                temp.setOrder(order);
//                temp.setQuantity(orderItems.get(i).getQuantity());
                this.orderItemsRepo.save(temp);
            }
            order.setOrderItems(orderDto.getOrderItems());
            order.setTotalPrice(orderDto.getTotalPrice());
            order.setStatus("PAID");
            order.setPaymentMethod(orderDto.getPaymentMethod());
            order.setAddress(orderDto.getAddress());
            order.setCreatedDate(LocalDate.now());
            order.setCustomer1(customer);
            System.out.println(order);
            order.setOrderId(order.getOrderId());
            Order tempOrder = order;
            Order savedOrder = this.orderRepo.save(tempOrder);
            System.out.println(savedOrder);
            return savedOrder;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Order> getAllOrders(String CustomerId) {
        try {
            List<Order> orders =  this.orderRepo.getAllByCustomer(CustomerId);
            return orders;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
