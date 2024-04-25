package com.ecom.prodservice.productservicev1.service;


import com.ecom.prodservice.productservicev1.dto.ProductRequest;
import com.ecom.prodservice.productservicev1.dto.ProductResponse;
import com.ecom.prodservice.productservicev1.model.Product;
import com.ecom.prodservice.productservicev1.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product createProduct(ProductRequest productRequest) {

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        log.info("{} {} prduct saved" , product.getId() , product.getName() );
       return  productRepository.save(product);


    }

    public List<ProductResponse> getALlProducts() {



        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();

    }

    private ProductResponse mapToProductResponse(Product product) {

        ProductResponse response = ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                     .build();

        return response;
    }

    public Product getProductByName(String name) {

        return productRepository.findByName(name);
    }

    public Product getProductByDesc(String desc) {

        return productRepository.findByDescription(desc);
    }
}
