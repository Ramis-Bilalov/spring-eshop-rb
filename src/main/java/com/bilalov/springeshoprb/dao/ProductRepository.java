package com.bilalov.springeshoprb.dao;

import com.bilalov.springeshoprb.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}