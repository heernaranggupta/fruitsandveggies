package com.hydroponic.ecomm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Builder
@AllArgsConstructor
@Getter
@Document
@Setter
@Data
public class Customer {
    @Id
    private String _id;
    private Name name;
    @Indexed(name = "customer_phone_number", direction = IndexDirection.DESCENDING, background = true, unique = true)
    private BigInteger phoneNumber;
    private Address address;
}
