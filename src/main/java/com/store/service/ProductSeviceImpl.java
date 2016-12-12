package com.store.service;

import com.google.common.collect.Lists;
import com.store.dao.ProductRepository;
import com.store.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductSeviceImpl implements ProductService {

    @Autowired ProductRepository repository;


    @Override public List<Product> getProducts() {
        return Lists.newArrayList(repository.findAll());
    }
}
