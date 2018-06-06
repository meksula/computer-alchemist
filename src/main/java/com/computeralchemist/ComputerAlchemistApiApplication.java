package com.computeralchemist;

import com.computeralchemist.configuration.CacheAppConfig;
import com.computeralchemist.configuration.SecurityConfig;
import com.computeralchemist.configuration.SecurityMethodConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @Author
 * Karol Meksuła
 * 12-04-2018
 * */

@SpringBootApplication
@Import({CacheAppConfig.class, SecurityConfig.class, SecurityMethodConfig.class})
public class ComputerAlchemistApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerAlchemistApiApplication.class, args);
	}

}
