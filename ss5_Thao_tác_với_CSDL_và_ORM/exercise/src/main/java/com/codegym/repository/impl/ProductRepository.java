package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {


    @Override
    public List<Product> findAll() {
        Session session=null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product").getResultList();
        }finally {
            if (session != null) {
                session.close();
            }
        }

        return productList;
    }

    @Override
    public void update(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction!=null) {
                transaction.rollback();
            }
        }finally {
            if (session!=null) {
                session.close();
            }
        }
    }

    @Override
    public Product findIndexById(int id) {
        Session session = null;
        Product product = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("FROM Product where id= :x")
            .setParameter("x",id)
            .getSingleResult();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void delete(int id) {
        Product product = findIndexById(id);
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void add(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction!=null) {
                transaction.rollback();
            }
        }finally {
            if (session!=null) {
                session.close();
            }
        }

    }


    @Override
    public List<Product> findByName(String nameProduct) {
        Session session = null;
        List<Product> product = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            product = (List<Product>) session.createQuery("FROM Product where name like concat('%',:name,'%') ")
                    .setParameter("name",nameProduct)
                    .getResultList();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }
}
