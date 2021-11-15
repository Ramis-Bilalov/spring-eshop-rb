package com.bilalov.springeshoprb.service;

import com.bilalov.springeshoprb.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();
    void addToUserBucket(Long productId, String username);
    void addProduct(ProductDTO dto);
    ProductDTO getById(Long id);
}