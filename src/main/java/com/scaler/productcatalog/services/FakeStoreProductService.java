package com.scaler.productcatalog.services;

import com.scaler.productcatalog.dtos.FakeStoreDto;
import com.scaler.productcatalog.dtos.GenericProductDto;
import com.scaler.productcatalog.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    private String getProducturl="https://fakestoreapi.com/products/{id}";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreDto> response =
                restTemplate.getForEntity(getProducturl, FakeStoreDto.class,id);

        FakeStoreDto fakeStoreDto= response.getBody();
        GenericProductDto product = new GenericProductDto();
        product.setImage(fakeStoreDto.getImage());
        product. setDescription(fakeStoreDto.getDescription());
        product.setTitle(fakeStoreDto.getTitle());
        product.setPrice(fakeStoreDto.getPrice());
        product.setCategory(fakeStoreDto.getCategory());
        return product;
    }
}
