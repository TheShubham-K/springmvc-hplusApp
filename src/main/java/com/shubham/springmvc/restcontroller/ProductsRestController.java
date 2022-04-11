package com.shubham.springmvc.restcontroller;

import com.shubham.springmvc.beans.Product;
import com.shubham.springmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsRestController {

    @Autowired
    private ProductRepository productRepository;

//    @GetMapping("/hplus/rest/products")
//    @ResponseBody
//    public List<Product> getProducts(){
//        // call product repo
//        List<Product> products = new ArrayList<>();
//        productRepository.findAll().forEach(products::add);
//        return products;
//    }

    @GetMapping("/hplus/rest/products")
    public ResponseEntity getProductsByRequestParam(@RequestParam("name") String name){
        List<Product> products = productRepository.searchByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/hplus/rest/products/{name}")
    public ResponseEntity getProductsByPathVariables(@PathVariable("name") String name){
        List<Product> products = productRepository.searchByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
