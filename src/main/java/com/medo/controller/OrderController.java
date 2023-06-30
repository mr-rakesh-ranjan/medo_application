package com.medo.controller;

import com.medo.dto.OrderDto;
import com.medo.entity.Order;
import com.medo.service.OrderService;
import com.medo.service.impl.OrderServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("order/{cust_id}/create")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto, @PathVariable String cust_id){
       System.out.println("Controller 1");
       try {
           Order order = this.orderService.createOrder(orderDto, cust_id);
           System.out.println("from try block Controller" + order);
           return new ResponseEntity<>(order, HttpStatus.CREATED);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("all-order/{customerId}")
    public ResponseEntity<List<Order>> getAllOrder(@PathVariable("customerId") String customerId){
        try {
            List<Order> list = this.orderService.getAllOrders(customerId);
            System.out.println(list.toString());
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
