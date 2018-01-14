package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.h2.server.web.WebServlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EntityScan({"model"})
@ComponentScan({"controller","service","dao","repository", "model"})
public class TransactionApp {
    public static void main(String[] args) {
        SpringApplication.run(TransactionApp.class, args);
    }

    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());

        registrationBean.addUrlMappings("/console/*");

        return registrationBean;

    }
}
