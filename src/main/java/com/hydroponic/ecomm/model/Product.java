package com.hydroponic.ecomm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Document
@Setter
@Data
public class Product {

    private String _id;
    private Integer product_id;
    private String name;
    private String description;
    private String category;
    private List<Float> quantities;
    private Integer price;
    private Integer priceType;
}
