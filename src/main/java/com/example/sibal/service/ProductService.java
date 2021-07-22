package com.example.sibal.service;

import com.example.sibal.domain.Product;
import com.example.sibal.dto.respones.ProductDetailRes;
import com.example.sibal.dto.respones.ProductSimpleRes;
import com.example.sibal.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductSimpleRes>findSimpleProduct(){
        List<Product> products = productRepository.findAll();
        return ProductSimpleRes.list(products);
    }

    @Transactional(readOnly = true)
    public ProductDetailRes findDetailProduct(Long id){
        Product products = productRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디를 찾을 수 없습니다")
        );
        return ProductDetailRes.of(products);
    }

}