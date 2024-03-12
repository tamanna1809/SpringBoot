package com.example.Product.models;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product {
    private Long id;
    private int UserId;
    private Date date;
    private List<cart> products;
}