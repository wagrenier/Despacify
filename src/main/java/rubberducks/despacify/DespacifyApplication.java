package rubberducks.despacify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controllers"} )
public class DespacifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DespacifyApplication.class, args);
    }

}

