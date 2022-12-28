package com.codegym.exercise.dto;

import com.codegym.exercise.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto,Integer> products = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> products) {
        this.products = products;
    }


    public Map<ProductDto, Integer> getProducts(){
        return products;
    }

    public void addProduct(ProductDto product){
        if (products.containsKey(product)) {
            Integer currenValue = products.get(product);
            products.replace(product,currenValue+1);
        }else {
            products.put(product,1);
        }
    }
    public void decreaseProduct(ProductDto productDto){
        if (products.containsKey(productDto)){
            Integer currentValue = products.get(productDto);
            if (currentValue > 1){
                products.replace(productDto,currentValue - 1);
            }else {
                products.remove(productDto);
            }
        }
    }
    public Double countTotalPayment(){
        double payment = 0;
        for (Map.Entry<ProductDto,Integer> entry : products.entrySet()){
            payment += entry.getKey().getPrice() * (double)entry.getValue();
        }
        return payment;
    }

    public void remove(ProductDto productDto){
        products.remove(productDto);
    }
}
