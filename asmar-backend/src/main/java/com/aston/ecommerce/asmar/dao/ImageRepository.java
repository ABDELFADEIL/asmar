package com.aston.ecommerce.asmar.dao;

import com.aston.ecommerce.asmar.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query("SELECT i from Image i where i.product = ?1")
    List<Image> findUrlImagesByProduct(Image image);
}
