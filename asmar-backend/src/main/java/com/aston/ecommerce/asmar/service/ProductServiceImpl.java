package com.aston.ecommerce.asmar.service;

import com.aston.ecommerce.asmar.dao.CategoryRepository;
import com.aston.ecommerce.asmar.dao.ProductRepository;
import com.aston.ecommerce.asmar.dto.ProductDTO;
import com.aston.ecommerce.asmar.dto.ProductDetailDTO;
import com.aston.ecommerce.asmar.dto.mapper.ProductMapper;
import com.aston.ecommerce.asmar.entity.Category;
import com.aston.ecommerce.asmar.entity.Product;
import com.aston.ecommerce.asmar.exption.ProductExpception;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements IProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(
                              ProductMapper productMapper,
                              ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDetailDTO getProductById(Integer id) {
         Product product = productRepository.getById(id);
        return productMapper.toProductDetailDto(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<ProductDTO> getProductByLabelOrDescription(String keyword) {
        List<Product>
                  products =  productRepository.findByLabelContainingOrDescriptionContainingOrderByDescription(keyword, keyword);
        return productMapper.toProductDtos(products);
        }

    
    @Override
    public List<ProductDetailDTO> getProductsByDate(Integer nb){
        Page<Product> products = productRepository.findAll(
                PageRequest.of(0, Math.toIntExact(nb), Sort.by(Sort.Direction.DESC, "creationDate")));
        return productMapper.toProductDetailDtos(products.getContent());
        }


    @Override
    public List<ProductDTO> getProductsByCategoryId(Integer categoryId){
        List<Product> products = productRepository.findAllByCategoryIdOrderByLabelAsc(categoryId);
        return productMapper.toProductDtos(products);
        }

    @Override
    public List<ProductDTO> findAll() {
        return productMapper.toProductDtos(productRepository.findAll());
    }

    @Override
    public ProductDetailDTO addProduct(ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        Category category = categoryRepository.getById(productDTO.getCategory().getId());
        if (category== null){
            throw new ProductExpception("category not found " + category);
        }
        product.setCategory(category);
        product = productRepository.save(product);
        return productMapper.toProductDetailDto(product);
    }


}