package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    
    List<Image> findAllByProductId(Integer productId);
}
