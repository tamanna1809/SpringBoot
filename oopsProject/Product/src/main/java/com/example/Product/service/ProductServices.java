package com.example.Product.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Product.dto.ProductDto;
import com.example.Product.models.Product;

@Service
public class ProductServices implements serviceInterface{
    private RestTemplate restTemplate= new RestTemplate();

    
    @Override
    public Product[] getAllProducts(){
        ResponseEntity<Product[]> response = restTemplate.getForEntity("https://fakestoreapi.com/carts",Product[].class);
        Product[] allProducts = response.getBody();
        return allProducts;
    }
    

    @Override
    public Product getSingleProduct(Long id){
        ProductDto abc=restTemplate.getForObject("https://fakestoreapi.com/carts/" + id, ProductDto.class);

        Product product=new Product();
        product.setId(abc.getId());
        product.setUserId(abc.getUserId());
        product.setDate(abc.getDate());
        product.setProducts(abc.getProducts());        

        return product;
    }


    @Override
    public Product updateProduct(Long id) {
        Product product = getSingleProduct(id);
        ProductDto newp = new ProductDto();

        newp.setId(product.getId());
        newp.setUserId(product.getUserId());
        newp.setDate(product.getDate());
        newp.setProducts(product.getProducts());

        restTemplate.put("https:/fakestoreapi.com/carts/" + id, newp);
        return product;
    }


    public Product deleteProduct(Long id) {
        Product delp = getSingleProduct(id);
        
        restTemplate.delete("https:/fakestoreapi.com/carts/" + id);
        return delp;
    }


    public Product postProduct(Product a){
        ProductDto changes = new ProductDto();

        changes.setId(a.getId());
        changes.setUserId(a.getUserId());
        changes.setDate(a.getDate());
        changes.setProducts(a.getProducts());

        restTemplate.postForObject("https:/fakestoreapi.com/carts/", changes, ProductDto.class);
        return a;
    }
}