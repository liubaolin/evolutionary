package top.evolutionary.data.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import top.evolutionary.data.mongo.service.demo.CreateCollectionDemo;

/**
 * @EnableMongoRepositories By default, @EnableMongoRepositories scans the current package for any interfaces that extend one of Spring Data’s repository interfaces. You can use its basePackageClasses=MyRepository.class to safely tell Spring Data MongoDB to scan a different root package by type if your project layout has multiple projects and it does not find your repositories.
 */
@EnableMongoRepositories
@SpringBootApplication
public class EvolutionaryDataMongoApplication implements CommandLineRunner {

    @Autowired
    private CreateCollectionDemo createCollectionDemo;

    public static void main(String[] args) {
        SpringApplication.run(EvolutionaryDataMongoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

//        createCollectionDemo.createCollectionDemo();
//        createCollectionDemo.insertLageData();
    }

}
