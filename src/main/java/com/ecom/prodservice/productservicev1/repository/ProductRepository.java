package com.ecom.prodservice.productservicev1.repository;


import com.ecom.prodservice.productservicev1.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String > {


    Product findByName(String name);

    Product findByDescription(String description);

}
