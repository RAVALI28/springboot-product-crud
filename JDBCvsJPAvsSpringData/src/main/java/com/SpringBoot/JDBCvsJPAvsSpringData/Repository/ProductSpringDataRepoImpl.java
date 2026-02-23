package com.SpringBoot.JDBCvsJPAvsSpringData.Repository;

import com.SpringBoot.JDBCvsJPAvsSpringData.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//Using the Spring Data JPA Implementation instead of JPA and Hibernate
@Repository
public interface ProductSpringDataRepoImpl extends JpaRepository<Product, Integer> {

  //  Product updateProduct(Product productToBeUpdated, int id);

    List<Product> findAllByName(String name);

    List<Product> findAllByNameAndDescription(String name, String description);
}
