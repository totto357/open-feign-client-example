package com.example.ofc.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ofc.model.WeatherInfo;

@FeignClient(name = "weather", url = "weather.livedoor.com")
public interface WeatherClient {

	@RequestMapping(method = RequestMethod.GET, value = "/forecast/webservice/json/v1") 
	ResponseEntity<WeatherInfo> getWeatherInfo(@RequestParam("city") Long city);

}
