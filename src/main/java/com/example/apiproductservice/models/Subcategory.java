package com.example.apiproductservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Subcategory extends BaseModel{

    private String lastname;
}
