package com.example.Product.service;

import com.example.Product.models.Product;

public interface serviceInterface {
    Product[] getAllProducts();

    Product getSingleProduct(Long id);

    Product updateProduct(Long id);

    Product deleteProduct(Long id);
}
