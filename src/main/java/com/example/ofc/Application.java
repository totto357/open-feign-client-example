package com.example.ofc;

import com.example.ofc.model.WeatherInfo;
import com.example.ofc.api.WeatherClient;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
@EnableFeignClients
@EnableAutoConfiguration
@Slf4j
public class Application implements CommandLineRunner {

	@Autowired
	private WeatherClient weatherClient;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		// 東京都: 130010
		ResponseEntity<WeatherInfo> response = weatherClient.getWeatherInfo(130010L);
		log.info(response.getBody().toString());
	}
}
