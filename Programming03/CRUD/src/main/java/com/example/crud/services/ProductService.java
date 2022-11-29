package com.example.crud.services;

import com.example.crud.dao.ProductRepository;
import com.example.crud.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository   repo;

    public Product get(int id){
        return (Product) repo.findById(id).get();
    }

    public List<Product> getAll(){
        return repo.findAll();
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public void add(Product product){
        repo.save(product);
    }

    public void update(Product product){

        repo.save(product);
    }

}

