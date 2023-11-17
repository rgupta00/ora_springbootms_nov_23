package com.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    public String callWeatherService( int temp){
        return restTemplate.getForObject("http://localhost:8081/weather/"+temp, String.class);
    }
    
}
