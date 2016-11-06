package lv.robertsv.webjob;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = { "lv.robertsv.webjob" })
@EnableTransactionManagement
public class JpaConfig implements DisposableBean {

	private EmbeddedDatabase ed;

	@Bean(name = "hsqlInMemory")
	public EmbeddedDatabase hsqlInMemory() {
		if (this.ed == null) {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			this.ed = builder.setType(EmbeddedDatabaseType.HSQL).build();
		}
		return this.ed;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("lv.robertsv.webjob");
		factory.setDataSource(this.hsqlInMemory());

		Properties ps = new Properties();
		ps.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		ps.put("hibernate.hbm2ddl.auto", "create");
		factory.setJpaProperties(ps);
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	@Override
	public void destroy() {
		if (this.ed != null) {
			this.ed.shutdown();
		}
	}

}