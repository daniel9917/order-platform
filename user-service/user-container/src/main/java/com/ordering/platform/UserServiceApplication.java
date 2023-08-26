package com.ordering.platform;

import com.ordering.platform.user.service.domain.UserDomainService;
import com.ordering.platform.user.service.domain.UserDomainServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {
    public static void main (String [] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public UserDomainService userDomainService (){
        return new UserDomainServiceImpl();
    }


}
