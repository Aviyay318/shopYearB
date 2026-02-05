package org.example.shopyearb;

import org.example.shopyearb.Entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Date;

@SpringBootApplication
@EnableCaching
public class ShopYearBApplication {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);



        Product product = new Product(1,2.5,"aplle","red","hbdc");
        System.out.println(product.getName().isEmpty());
        SpringApplication.run(ShopYearBApplication.class, args);

    }


}
