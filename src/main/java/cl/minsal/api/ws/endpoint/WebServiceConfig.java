package cl.minsal.api.ws.endpoint;


//import org.eclipse.persistence.annotations.Properties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.*;
// import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

// import javax.annotation.Resource;
// import javax.sql.DataSource;




@EnableTransactionManagement
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

  @Bean
  public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);

    return new ServletRegistrationBean(servlet , "/uv/ws/*");
  }

  @Bean(name = "rnc")
  public Wsdl11Definition defaultWsdl11Definition() {
    SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
    wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/RegistroNacionalCancer.wsdl"));

    return wsdl11Definition;
  }

  // private static final String JNDI_NAME = "jdni/rnc";

  // @Bean
  // public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
  //   return new PropertySourcesPlaceholderConfigurer();
  // }

  // @Bean
  // @Primary
  // @Resource(name = JNDI_NAME)
  // public DataSource dataSource() {

  //     JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
  //     jndiDataSourceLookup.setResourceRef(true);
  //     return jndiDataSourceLookup.getDataSource(JNDI_NAME);

  // }

  // @Bean
  // public JdbcTemplate jdbcTemplate() {
  //   return new JdbcTemplate(dataSource());
  // }
}





