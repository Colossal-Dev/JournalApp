package net.project.journalApp.Service;

import net.project.journalApp.api_response.WeatherResponse;
import net.project.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    @Autowired
    RedisService redisService;


    @Value("${weather.api.key}")
    private  String apiKey ;


    public WeatherResponse getWeather(String city) {

        WeatherResponse weatherResponse  = redisService.get("Weather_of_"+city,WeatherResponse.class);

        if(weatherResponse !=null) return weatherResponse;
        else {
            String finalApi = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace("<apikey>", apiKey).replace("<city>", city);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET,null, WeatherResponse.class);

            WeatherResponse body= response.getBody();

            if(body!=null) redisService.set("Weather_of_"+city,body,500L);

            return body;

        }


    }
}
