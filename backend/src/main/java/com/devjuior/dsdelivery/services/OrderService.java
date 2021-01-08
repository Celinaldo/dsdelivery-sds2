package com.devjuior.dsdelivery.services;


import com.devjuior.dsdelivery.entities.Order;
import com.devjuior.dsdelivery.orderDto.OrderDto;
import com.devjuior.dsdelivery.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public List<OrderDto> findAll(){
        List<Order> list = repository.findOrderWithProducts();
        return list.stream().map(x-> new OrderDto(x)).collect(Collectors.toList());


    }
}
