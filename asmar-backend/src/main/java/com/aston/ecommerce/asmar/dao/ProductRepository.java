package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.dto.ProductDto;
import com.aston.ecommerce.asmar.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE CONCAT(p.label,'', p.description) LIKE %?1%")
    List<Product> findProductsByLabelOrderByDescription(String keyword);

}