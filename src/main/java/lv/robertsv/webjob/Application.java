package lv.robertsv.webjob;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application  {
	
	// extends WebMvcAutoConfiguration

	// @Bean
	// public DozerBeanMapperFactoryBean
	// dozerBeanMapperFactoryBean(@Value("classpath*:mappings/*mappings.xml")
	// Resource[] resources) throws Exception {
	// final DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new
	// DozerBeanMapperFactoryBean();
	// // Other configurations
	//// dozerBeanMapperFactoryBean.setMappingFiles(resources);
	// return dozerBeanMapperFactoryBean;
	// }

//	@Bean(name = "org.dozer.Mapper")
//	public DozerBeanMapper dozerBean() {
//		List<String> mappingFiles = Arrays.asList("dozer-global-configuration.xml", "dozer-bean-mappings.xml",
//				"more-dozer-bean-mappings.xml");
//
//		DozerBeanMapper dozerBean = new DozerBeanMapper();
//		dozerBean.setMappingFiles(mappingFiles);
//		return dozerBean;
//	}
	
//	@Bean
//	public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean() {
//	    final DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
//	    dozerBeanMapperFactoryBean.setMappingBuilders(Arrays.asList(beanMappingBuilder()));
//	    return dozerBeanMapperFactoryBean;
//	}
	
	@Bean
	  public DozerBeanMapper dozerBean() {
//	    List<String> mappingFiles = Arrays.asList(
//	      "dozer-global-configuration.xml", 
//	      "dozer-bean-mappings.xml",
//	      "more-dozer-bean-mappings.xml"
//	    );

	    DozerBeanMapper dozerBean = new DozerBeanMapper();
//	    dozerBean.setMappisngFiles(mappingFiles);
	    return dozerBean;
	  }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
