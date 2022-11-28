package com.example.crud.controller;


import com.example.crud.model.Product;
import com.example.crud.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductServiceController {


    private ProductService service;

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") int id) {
        service.delete(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        product.setId(id);
        service.update(product);
        return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
    }


    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        service.add(product);
        return new ResponseEntity<>("Successfully created", HttpStatus.CREATED);
    }


    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct(){

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

}
