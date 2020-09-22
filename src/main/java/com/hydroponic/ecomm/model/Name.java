package com.hydroponic.ecomm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@Getter
@Document
@Setter
@Data
public class Name {
    private String firstName;
    private String middleName;
    private String lastName;
}
