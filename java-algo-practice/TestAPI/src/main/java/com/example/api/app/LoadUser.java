package com.example.api.app;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.api.model.User;
import com.example.api.repository.UserRepository;

@Configuration
public class LoadUser {
   

    private static final Logger log = LoggerFactory.getLogger(LoadUser.class);

  @Bean
  CommandLineRunner initDatabase(UserRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new User("rr", "R", "R")));
      log.info("Preloading " + repository.save(new User("r2", "R", "R2")));
    };
  }
 
}
