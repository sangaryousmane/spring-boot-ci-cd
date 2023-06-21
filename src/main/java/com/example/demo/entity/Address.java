package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Setter @Getter @NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "zip_code",
                column = @Column(length = 60)),
        @AttributeOverride(name = "country_of_birth",
        column = @Column(length = 100))
})
public class Address {

    private String zipcode;
    private String country;
    private String city;
}
