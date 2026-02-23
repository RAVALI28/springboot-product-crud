package com.SpringBoot.JDBCvsJPAvsSpringData.Controller;

import com.SpringBoot.JDBCvsJPAvsSpringData.Model.Product;
import com.SpringBoot.JDBCvsJPAvsSpringData.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    //Post Rest API for inserting the product
    //Create/save the product into the DB
    @PostMapping("/insertProduct")
    public Product insertProduct(@RequestBody Product product){
        return productService.saveproduct(product);

    }

    //Get Rest API for fetching the product from DB
    @GetMapping("/fetchAll")
    public List<Product> fetchAllProducts(){
       return productService.fetchAll();
    }

    //Get the product from DB by ID
    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable int id){
       Product product = productService.getProduct(id);
       if(product == null){
           return ResponseEntity.notFound().build();
       }else {
           return ResponseEntity.ok(product);
       }
    }

    //Get the product from DB by Name
    @GetMapping("/getProductByName/{name}")
    public List<Product> getProductByName(@PathVariable String name){
        return productService.getProductsByName(name);
    }

    //Update the existing product

    //delete a product from DB
    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProductById(@PathVariable int id){
        boolean isDeleted = productService.deleteProduct(id);
        return isDeleted ? "deleted succesfully" : "not deleted";
    }







}
