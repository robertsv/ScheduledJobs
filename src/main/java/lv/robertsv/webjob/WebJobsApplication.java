package lv.robertsv.webjob;

import org.dozer.DozerBeanMapper;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableWebSocketMessageBroker
@EnableScheduling
public class WebJobsApplication extends AbstractWebSocketMessageBrokerConfigurer {
	
	@Bean
	  public DozerBeanMapper dozerBean() {
	    DozerBeanMapper dozerBean = new DozerBeanMapper();
	    return dozerBean;
	  }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebJobsApplication.class, args);
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/gs-guide-websocket").withSockJS();
	}
	
	@Bean
    public StdSchedulerFactory  getStdSchedulerFactory() {
        return new StdSchedulerFactory();
    }  
	
	@Bean
    public Scheduler  getStdSchedulerFactory2(StdSchedulerFactory f) throws SchedulerException {
        return f.getScheduler();
    } 

}
