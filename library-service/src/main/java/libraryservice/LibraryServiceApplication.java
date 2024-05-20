package libraryservice;

import feign.Logger;
import feign.codec.ErrorDecoder;
import libraryservice.client.RetrieveMessageErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan({"libraryservice", "com.icolak.dal"})
public class LibraryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
	}

	@Bean
	public ErrorDecoder errorDecoder() {
		return new RetrieveMessageErrorDecoder();
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
