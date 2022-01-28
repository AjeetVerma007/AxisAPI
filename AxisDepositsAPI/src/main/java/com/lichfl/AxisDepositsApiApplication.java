package com.lichfl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@SpringBootApplication
@EnableWebSecurity

public class AxisDepositsApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(AxisDepositsApiApplication.class, args);
	}
}

/*public class AxisDepositsApiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {

		SpringApplication.run(AxisDepositsApiApplication.class, args);
	}

	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { 
		// TODO Auto-generated method
	   return builder.sources(AxisDepositsApiApplication.class); }

}
*/
