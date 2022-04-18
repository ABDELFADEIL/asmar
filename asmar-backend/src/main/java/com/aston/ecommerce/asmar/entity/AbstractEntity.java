package com.aston.ecommerce.asmar.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.persistence.*;
import java.io.Serializable;


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
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
