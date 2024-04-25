package com.ecom.prodservice.productservicev1.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value="product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Product {

     @Id
      String id ;
    String name ;
    String description ;
    BigDecimal price ;

}
