package be.thomasmore.graduaten.hellospring.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "mySqlDataSource")
    @Primary
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://frituur.mysql.database.azure.com:3306/frituur?useSSL=FALSE");
        dataSourceBuilder.username("Arno");
        dataSourceBuilder.password("passwoord12345!");
        return dataSourceBuilder.build();
    }

}
