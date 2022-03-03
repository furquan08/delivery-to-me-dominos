package com.jos.dem.springboot.cucumber;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class CucumberApplication {


    @Value("${store.boundary.service.url}")
    private String sbsUrl;

   // private String usersApi = "https://gorest.co.in/public/v2/users/";

	public static void main(String[] args) {
		SpringApplication.run(CucumberApplication.class, args);
  }

  @Bean
  @Qualifier("webClient")
  WebClient getWebClient() {
      return WebClient
              .builder()
              .baseUrl(sbsUrl)
              .defaultHeader("DPZ-Market", "UNITED_STATES")
              .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
              .build();
  }

   /* @Bean
    @Qualifier("userWebclient")
    WebClient getUserWebClient() {
        return WebClient
                .builder()
                .baseUrl(usersApi)
                .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .build();
    }*/

}
