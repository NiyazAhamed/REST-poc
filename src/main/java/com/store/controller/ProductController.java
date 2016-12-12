package com.store.controller;

import com.store.domain.Product;
import com.store.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/products")
@Api(value="products", tags="products", description = "Endpoints for product CRUD operation")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
   
    public Collection<Product> getProducts(){
        return productService.getProducts();
    } 
}
