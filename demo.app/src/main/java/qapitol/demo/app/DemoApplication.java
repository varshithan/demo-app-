package qapitol.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"qapitol.demo.app","qapitol.demo.app.controllers","qapitol.demo.app.entity","qapitol.demo.app.repository"})


public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
