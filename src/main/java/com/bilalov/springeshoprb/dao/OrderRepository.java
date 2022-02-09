package com.bilalov.springeshoprb.dao;

import com.bilalov.springeshoprb.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}