package com.aston.ecommerce.asmar.entity;

import org.apache.logging.log4j.LogManager;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;


/**
 * Mother of simple entity class.
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {
    private static final Logger LOG = LogManager.getLogger();
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
