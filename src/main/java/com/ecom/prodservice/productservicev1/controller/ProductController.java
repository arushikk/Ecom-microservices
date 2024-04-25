package com.ecom.prodservice.productservicev1.controller;


import com.ecom.prodservice.productservicev1.dto.ProductRequest;
import com.ecom.prodservice.productservicev1.model.Product;
import com.ecom.prodservice.productservicev1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")

public class ProductController {

    @Autowired
    private ProductService productService ;



    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);

    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts(){
        return productService.getALlProducts();
    }

    @GetMapping("/get")
    public Product getProductByname(@RequestParam("name") String name){
        return productService.getProductByName(name);
    }

    @GetMapping("/get/{name}")
    public Product getProductBynameP(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @GetMapping("/getbydesc/{desc}")
    public Product getProductByDesc(@PathVariable String desc){
        return productService.getProductByDesc(desc);
    }
}
