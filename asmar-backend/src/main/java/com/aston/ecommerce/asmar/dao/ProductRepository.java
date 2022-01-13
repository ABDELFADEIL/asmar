package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    Page<Product> findAllByDescriptionContainsOrderByLabel(String description, String label, Pageable pageable);
    //@Query(value = "SELECT * FROM product p WHERE p.label = ?1 OR "
            // retourne une liste de products
 /*   Page<Product>*/


}
