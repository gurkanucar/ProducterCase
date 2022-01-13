package com.gudev.productercase;

import com.gudev.productercase.model.Player;
import com.gudev.productercase.model.Position;
import com.gudev.productercase.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducterCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducterCaseApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(PlayerRepository repository) {
        return (args) -> {
            repository.save(new Player("Michael", "Jordan", Position.PF));
            repository.save(new Player("LeBron", "James", Position.C));
            repository.save(new Player("Kobe", "Bryant", Position.SG));
            repository.save(new Player("Hidayet", "Turkoglu", Position.PG));
        };
    }

}
