package academy.devdojo.springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//localhost:8080/anime/list
public class ApplicationStart {
    public static void main(String[] args) {

        SpringApplication.run(ApplicationStart.class, args);
    }
}
