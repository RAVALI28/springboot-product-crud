package com.SpringBoot.JDBCvsJPAvsSpringData.Service;

import com.SpringBoot.JDBCvsJPAvsSpringData.Model.Product;
import com.SpringBoot.JDBCvsJPAvsSpringData.Repository.ProductSpringDataRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductSpringDataRepoImpl productSpringDataRepo;

    //Saving the product to the DB
    public Product saveproduct(Product product){
       return productSpringDataRepo.save(product);
    }


    //Fetching all the products from DB
    public List<Product> fetchAll(){
        return productSpringDataRepo.findAll();
    }


    //Fetching a specific product from DB by ID
    public Product getProduct(int id) {
        Optional<Product> optionalProduct = productSpringDataRepo.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }else {
            return null;
        }
    }

    //Fetching a specific product from DB by Name
    public List<Product> getProductsByName(String name) {
       return productSpringDataRepo.findAllByName(name);
    }

    public boolean deleteProduct(int id) {
        List<Product> productList = productSpringDataRepo.findAll();
        boolean isProductExist = false;
        if(productList != null){
            isProductExist = productList.stream().anyMatch(product -> product.getId() == id);
        }
        productSpringDataRepo.deleteById(id);
         return isProductExist;
    }
}
