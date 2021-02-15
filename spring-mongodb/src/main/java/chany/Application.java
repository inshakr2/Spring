package chany;

import chany.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class Application {

    @Autowired
    MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            Account account = new Account();
            account.setEmail("chany@.com");
            account.setUsername("chany");

            mongoTemplate.insert(account);

            System.out.println("Fin");
        };
    }

}
