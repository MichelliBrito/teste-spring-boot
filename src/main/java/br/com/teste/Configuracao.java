package br.com.teste;

import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;




//@EnableAutoConfiguration
@SpringBootApplication
public class Configuracao {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Configuracao.class, args);
    }
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
        dataSource.setUsername("root");
        dataSource.setPassword("Michelli14");
        return dataSource;
    }
}
