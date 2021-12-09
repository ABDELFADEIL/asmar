package com.aston.ecommerce.asmar.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Image extends AbstractEntity{

    private String url;
}
