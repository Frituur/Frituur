package be.thomasmore.graduaten.hellospring;

import be.thomasmore.graduaten.hellospring.entities.User;
import be.thomasmore.graduaten.hellospring.security.PasswordConfig;
import be.thomasmore.graduaten.hellospring.shared.DatabaseInitializer;
import be.thomasmore.graduaten.hellospring.shared.FileCreater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FrituurspringApplication extends SpringBootServletInitializer {



	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FrituurspringApplication.class);
	}


	private static final Logger logger = LoggerFactory.getLogger(FrituurspringApplication.class);


	public static void main(String[] args) throws SQLException, IOException {
		FileCreater fileCreater = new FileCreater();
		fileCreater.AssignTempFile("temp2.txt");

		logger.info("The application is starting now");
		DatabaseInitializer databaseInitializer = new DatabaseInitializer(logger);
		Connection conn = databaseInitializer.GetConnection();

		SpringApplication.run(FrituurspringApplication.class, args);
	}

}
