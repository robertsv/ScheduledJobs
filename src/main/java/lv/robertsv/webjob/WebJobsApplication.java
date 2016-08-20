package lv.robertsv.webjob;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class WebJobsApplication  {
	
	@Bean
	  public DozerBeanMapper dozerBean() {
	    DozerBeanMapper dozerBean = new DozerBeanMapper();
	    return dozerBean;
	  }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebJobsApplication.class, args);
	}
}
