package com.devjuior.dsdelivery.services;


import com.devjuior.dsdelivery.dto.ProductDto;
import com.devjuior.dsdelivery.entities.Order;
import com.devjuior.dsdelivery.entities.OrderStatus;
import com.devjuior.dsdelivery.entities.Product;
import com.devjuior.dsdelivery.orderDto.OrderDto;
import com.devjuior.dsdelivery.repositories.OrderRepository;
import com.devjuior.dsdelivery.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDto> findAll(){
        List<Order> list = repository.findOrderWithProducts();
        return list.stream().map(x-> new OrderDto(x)).collect(Collectors.toList());
    }
    @Transactional
    public OrderDto insert(OrderDto dto){
        Order order = new Order(null , dto.getAddress(), dto.getLatitude(), dto.getLongitude(),
                Instant.now(), OrderStatus.PEDING);
        for (ProductDto p : dto.getProducts()){
            Product product = productRepository.getOne(p.getId());
            order.getProducts().add(product);
        }
        order = repository.save(order);
        return new OrderDto(order);
    }

    @Transactional
    public OrderDto setDelivered(Long id){
        Order order = repository.getOne(id);
        order.setStatus(OrderStatus.DELIVERED);
        return new OrderDto(order);
    }
}
