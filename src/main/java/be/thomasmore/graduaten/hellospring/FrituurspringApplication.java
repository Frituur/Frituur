package be.thomasmore.graduaten.hellospring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FrituurspringApplication {
	private static final Logger logger = LoggerFactory.getLogger(FrituurspringApplication.class);

	public static void main(String[] args) throws SQLException {
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");

		String jdbcUrl = "jdbc:mysql://frituur.mysql.database.azure.com:3306/frituur?useSSL=FALSE";

		Connection connection = DriverManager.getConnection(jdbcUrl, "Arno", "passwoord12345!");
		logger.info("Database connected");



		SpringApplication.run(FrituurspringApplication.class, args);
	}

}
