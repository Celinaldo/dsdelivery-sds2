package com.devjuior.dsdelivery.services;


import com.devjuior.dsdelivery.dto.ProductDto;
import com.devjuior.dsdelivery.entities.Product;
import com.devjuior.dsdelivery.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDto> findAll(){
        List<Product> list = repository.findAll();
        return list.stream().map(x-> new ProductDto(x)).collect(Collectors.toList());


    }
}
