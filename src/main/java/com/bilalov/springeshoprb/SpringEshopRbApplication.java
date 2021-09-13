package com.bilalov.springeshoprb;

import com.bilalov.springeshoprb.service.BucketService;
import com.bilalov.springeshoprb.service.ProductService;
import com.bilalov.springeshoprb.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableConfigServer
@SpringBootApplication
public class SpringEshopRbApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringEshopRbApplication.class, args);
        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
        System.out.println(encoder.encode("pass"));     // для получения зашифрованного кода

        BucketService bucketService = context.getBean(BucketService.class);
        ProductService productService = context.getBean(ProductService.class);
        UserService userService = context.getBean(UserService.class);
    }
}
