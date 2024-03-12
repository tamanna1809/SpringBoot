package com.example.Product.dto;

import java.util.Date;
import java.util.List;

import com.example.Product.models.cart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductDto {
    private Long id;
    private int UserId;
    private Date date;
    private List<cart> products;
}