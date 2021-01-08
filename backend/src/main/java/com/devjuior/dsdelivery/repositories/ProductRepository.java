package com.devjuior.dsdelivery.repositories;

import com.devjuior.dsdelivery.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Long> {



}
