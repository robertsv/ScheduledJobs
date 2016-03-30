package lv.robertsv.webjob;

import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

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

	@Bean(name = "org.dozer.Mapper")
	public DozerBeanMapper dozerBean() {
		List<String> mappingFiles = Arrays.asList("dozer-global-configuration.xml", "dozer-bean-mappings.xml",
				"more-dozer-bean-mappings.xml");

		DozerBeanMapper dozerBean = new DozerBeanMapper();
		dozerBean.setMappingFiles(mappingFiles);
		return dozerBean;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
