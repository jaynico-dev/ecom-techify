package com.nico.ecom_proj.service;

import com.nico.ecom_proj.model.Product;
import com.nico.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {

        return repo.findAll();

    }

    public Product getProductById(int id) {
        return repo.findById(id)
                .orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        // get image details and set to product object
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageDate(imageFile.getBytes());

        return repo.save(product);
    }
}
