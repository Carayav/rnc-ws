package cl.minsal.api.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;




@SpringBootApplication
public class SpringWsApplication extends SpringBootServletInitializer {
    // TODO Auto-generated catch block
    //

  public static void main(String[] args) {
    SpringApplication.run(SpringWsApplication.class, args);
  }


   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
      return application.sources(SpringWsApplication.class);
   }


}
