package com.example.apiproductservice.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @Id
    private Long id;
    private Date CreatedAt;
    private Date LastUpdatedAt;
    private Boolean isDeleted;

}
