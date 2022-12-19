package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {


    private static List<Product> productList ;

    static {
        productList = new ArrayList<>();
        productList.add(new Product(1,"xiaomi",1400,"màu xám","Công PRO"));
        productList.add(new Product(2,"iphone",1400,"màu xanh","anh Chiến Sĩ"));
        productList.add(new Product(3,"samsung",1400,"màu đen","Chú Tân Idol"));
        productList.add(new Product(4,"Cường",1400,"màu  hồng","Chú Cường Vlog"));
        productList.add(new Product(4,"SamSung s22 utra",234234,"màu đen","Cường baten đơ"));
    }


    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void update(Product product) {
        for (Product product1: productList){
            if (product1.getId()==product.getId()) {
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setDescribe(product.getDescribe());
                product1.setProducer(product.getProducer());
            }
        }
    }

    @Override
    public Product findIndexById(int id) {
        for (Product x: productList) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public int getIdAutoIncrement(){
        return productList.get(productList.size()-1).getId() +1;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < productList.size() ; i++) {
            if (productList.get(i).getId() == id){
                productList.remove(productList.get(i));
            }
        }
    }

    @Override
    public void add(Product product) {
        product.setId(getIdAutoIncrement());
        productList.add(product);
    }

    @Override
    public List<Product> findByName(String nameProduct) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i <productList.size() ; i++) {
            if (productList.get(i).getName().contains(nameProduct)) {
                products.add(productList.get(i)) ;
            }
        }
        return products;
    }
}
