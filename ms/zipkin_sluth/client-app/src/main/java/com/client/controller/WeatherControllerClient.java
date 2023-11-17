package com.client.controller;

import com.client.service.WeatherServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherControllerClient {
    private Logger logger= LoggerFactory.getLogger(WeatherControllerClient.class);
    @Autowired
   private WeatherServiceClient client;

    @GetMapping("weatherclient/{temp}")
    public String wetherInfo(@PathVariable int temp) {
        logger.info("client-app: WeatherControllerClient: wetherInfo method is called");
        String weather= client.callWeatherService(temp);
        logger.info("client-app: WeatherControllerClient: wetherInfo method is finished");
        return weather;
    }
}
