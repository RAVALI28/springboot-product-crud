package com.SpringBoot.JDBCvsJPAvsSpringData.Repository;

import com.SpringBoot.JDBCvsJPAvsSpringData.Model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


//JPA and Hibernate Implementation

@Transactional
public class ProductRepoImpl implements ProductRepo{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void insert(Product product) {
        entityManager.merge(product);
    }

    @Override
    public List<Product> fetchAllProducts() {
        return entityManager.createQuery("SELECT p from Product p", Product.class).getResultList();
    }

    @Override
    public Product findById(int id) {
       return entityManager.find(Product.class, id);

    }

    @Override
    public Product updateProduct(Product productToBeUpdated, int id) {
        Product originalProduct = entityManager.find(Product.class, id);

        Product updatePrdct = entityManager.merge(productToBeUpdated);
        originalProduct.setName(updatePrdct.getName());
        originalProduct.setDescription(updatePrdct.getDescription());
        originalProduct.setStockQuantity(updatePrdct.getStockQuantity());
        originalProduct.setPrice(updatePrdct.getPrice());
       return originalProduct;
    }

    @Override
    public boolean deleteProductById(int id) {
        Product productToBeDeleted = entityManager.find(Product.class, id);
       entityManager.remove(productToBeDeleted);
       return true;
    }
}
