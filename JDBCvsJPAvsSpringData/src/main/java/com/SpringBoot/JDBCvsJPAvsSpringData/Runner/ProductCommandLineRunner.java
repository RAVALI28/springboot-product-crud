package com.SpringBoot.JDBCvsJPAvsSpringData.Runner;

import com.SpringBoot.JDBCvsJPAvsSpringData.Model.Product;
import com.SpringBoot.JDBCvsJPAvsSpringData.Repository.ProductSpringDataRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import java.util.List;


//@Component
public class ProductCommandLineRunner implements CommandLineRunner {


//    @Autowired
//    private ProductRepo productRepoImpl;

    @Autowired
    private ProductSpringDataRepoImpl productSpringDataRepoImpl;

    @Override
    public void run(String... args) throws Exception {

        //Using the JPA and Hibernate to insert the record
//        productRepoImpl.insert(new Product("Samsung", "samsung galaxy", 10, 999.99));
//        productRepoImpl.insert(new Product("Google", "Google pixel", 15,799.99));

        //Using the Spring Data JPA to insert the record
        productSpringDataRepoImpl.save(new Product("Samsung", "samsung galaxy", 10, 999.99));

        //List<Product> productList = productRepoImpl.fetchAllProducts();
        List<Product> productList = productSpringDataRepoImpl.findAll();

        for(Product product : productList){
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getStockQuantity());
            System.out.println(product.getPrice());
            System.out.println("----------------------------");
        }

       // Product product = productRepoImpl.findById(8);
       Product product1 = productSpringDataRepoImpl.findById(5).get();
        System.out.println("product name : " +product1.getName());
        System.out.println("---------------------------------------");


        //Updating the existing  product after creating a new one
        Product productToBeUpdate = new Product("Iphone", "iphone 17", 5, 1999.99);
        // productRepoImpl.updateProduct(productToBeUpdate, 6);

        //Updating the existing record
        Product existingProduct = productSpringDataRepoImpl.findById(1).get();
        Product appleProduct = new Product("Apple Vision", "Virtual Reality", 22, 599.99);
        existingProduct.setName(appleProduct.getName());
        existingProduct.setDescription(appleProduct.getDescription());
        existingProduct.setStockQuantity(appleProduct.getStockQuantity());
        existingProduct.setPrice(appleProduct.getPrice());
        productSpringDataRepoImpl.save(existingProduct);


        //Deleting a product
      //  productRepoImpl.deleteProductById(7);
        productSpringDataRepoImpl.deleteById(13);


    }
}
