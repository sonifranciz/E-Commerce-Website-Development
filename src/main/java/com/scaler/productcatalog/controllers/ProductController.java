package com.scaler.productcatalog.controllers;

import com.scaler.productcatalog.dtos.GenericProductDto;
import com.scaler.productcatalog.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping
    public void getAllProducts(){

    }
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }
    @DeleteMapping("{id}")
    public void deleteProductById(){

    }
    @PostMapping("{id}")
    public void createProductById(){

    }
    @PutMapping("{id}")
    public void updateProductById(){

    }
}
