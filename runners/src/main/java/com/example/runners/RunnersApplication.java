package com.example.runners;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.runners.run.Location;
import com.example.runners.run.Run;

@SpringBootApplication
public class RunnersApplication {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnersApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1,ChronoUnit.HOURS), 5, Location.OUTDOOR);
			log.info("Run: " + run);
		};
	}


}

	//ConfigurableApplicationContext context = SpringApplication.run(RunnersApplication.class, args);
		/* 
			var welcomeMessage = new WelcomeMessage();
			System.out.println(welcomeMessage.getWelcomeMessage());

			  				^	
							|
			ask spring for that particular welcome message. As right now that information is in another package.
			to have Spring take care of it easier, as for now, 
		*/
		// WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage"); this will breack because he context cant communicate with a different package.
		// so change the file location to this curret package to give the cntext to spring
		//now, i will use the same line of code but the context will identify the WelcomeMessage class and it methods
		//WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage");
		//System.out.println(welcomeMessage);
		// As is right now, the WelcomeMessage class doent have a toString so i print a memory location

		// SUPRISE, what is above was demonstrative, lol use
