package com.bilalov.springeshoprb.service;

import com.bilalov.springeshoprb.domain.Order;

public interface OrderService {
    void saveOrder(Order order);

    Order getOrder(Long id);
}