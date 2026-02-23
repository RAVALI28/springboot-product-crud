package com.SpringBoot.JDBCvsJPAvsSpringData.Repository;

import com.SpringBoot.JDBCvsJPAvsSpringData.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo {

     void insert(Product product);

     List<Product> fetchAllProducts();

     Product findById(int id);

     Product updateProduct(Product productToBeUpdated, int id);

     boolean deleteProductById(int id);


}
