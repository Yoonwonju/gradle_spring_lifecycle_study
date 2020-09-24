package gradle_spring_lifecycle_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import gradle_spring_lifecycle_study.spring.Client;
import gradle_spring_lifecycle_study.spring.Client2;

@Configuration			//해당 클래스를 스프링 설정 클래스로 지정한다.
@ComponentScan(basePackages = {"gradle_spring_lifecycle_study.spring"})
public class AppCtx {
	
//	@Bean
//	public Client client() {
//		Client client = new Client();
//		client.setHost("host");
//		return client;
//	}
	
	
	@Bean(initMethod = "connect", destroyMethod = "close")
	public Client2 client2() {
		return new Client2();
	}
}
