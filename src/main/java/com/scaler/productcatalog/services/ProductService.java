package com.scaler.productcatalog.services;

import com.scaler.productcatalog.dtos.GenericProductDto;
import com.scaler.productcatalog.models.Product;

public interface ProductService {

    GenericProductDto getProductById(Long Id);
}
