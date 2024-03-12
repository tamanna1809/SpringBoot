package com.example.Product.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.Product.models.Product;
import com.example.Product.service.ProductServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class ProductController {
    private ProductServices ps; 

    public ProductController(ProductServices productServices){
        this.ps= productServices;
    }

    @GetMapping("/carts")
    public Product[] getAllProduct() {
        return ps.getAllProducts();
    }


    @GetMapping("/carts/{id}")
    public Product getSingleProduct(@PathVariable("id")Long id) {
        return ps.getSingleProduct(id);
    }


    @PostMapping("/carts")
    public Product postProduct(@RequestBody Product a){
        return ps.postProduct(a);
    }


    @PatchMapping("/carts/{id}")
    public Product updateProduct(@PathVariable("id") Long id){
        return ps.updateProduct(id);
    }

    
    @DeleteMapping("carts/{id}")
    public Product deleteProduct(@PathVariable("id") Long id){
        return ps.deleteProduct(id);
    }
}
