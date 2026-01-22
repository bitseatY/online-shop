package com.ecommerce.demo.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Setter
@Getter
public class Address {
    private String country;
    private String city;
    private String cityState;
    private String street;
    private String houseNumber;
}
