package SDBA.src.SDBA.ApplicationStart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
    
@SpringBootApplication(scanBasePackages = "SDBA.src.SDBA")
public class ApplicationStartSBDA {
        public static void main(String[] args) {
            SpringApplication.run(ApplicationStartSBDA.class, args);
        }
    }
