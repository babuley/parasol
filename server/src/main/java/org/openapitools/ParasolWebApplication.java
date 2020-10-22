package org.openapitools;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.openapitools.services.IMockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"org.openapitools.event","org.openapitools.services","org.openapitools.report","org.openapitools.persistence", "org.openapitools.api" , "org.openapitools.configuration"})
public class ParasolWebApplication implements CommandLineRunner {


    @Autowired
    IMockDataService mockDataService;

    private final String[] resources = new String[] {"gas", "electricity", "water"};

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }

        //As requested, do not load mock data
        //loadMockData();
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(ParasolWebApplication.class).run(args);

    }

    private void loadMockData() {
        Arrays.stream(resources).forEach( resource -> {
            mockDataService.generateRecordsOf(resource).forEach(recordDAO -> {
                //recordRepo.save(recordDAO);
            });
        });
    }

    static class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }


    @Bean
    public WebMvcConfigurer webConfigurer() {
        return new WebMvcConfigurer() {
            /*@Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("Content-Type");
            }*/
        };
    }

    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}
