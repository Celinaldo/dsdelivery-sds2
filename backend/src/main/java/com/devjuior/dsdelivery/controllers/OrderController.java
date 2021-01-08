package com.devjuior.dsdelivery.controllers;


import com.devjuior.dsdelivery.dto.ProductDto;
import com.devjuior.dsdelivery.orderDto.OrderDto;
import com.devjuior.dsdelivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAll(){
        List<OrderDto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
