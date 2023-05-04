package edu.ardo.demo.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgresDataSource {
    @Bean
    @ConfigurationProperties("app.datasource") // pega todas dependencias do banco postgres no arquivo application.yml
    public HikariDataSource hikariDAtaSource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
