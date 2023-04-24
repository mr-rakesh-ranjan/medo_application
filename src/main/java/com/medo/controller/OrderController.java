package com.medo.controller;

import com.medo.dto.OrderDto;
import com.medo.entity.Order;
import com.medo.service.OrderService;
import com.medo.service.impl.OrderServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("{cust_id}/create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto, @PathVariable String cust_id){
        OrderDto orderDto1 = this.orderService.createOrder(orderDto, cust_id);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
