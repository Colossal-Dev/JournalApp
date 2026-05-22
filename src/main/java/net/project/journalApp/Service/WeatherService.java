package net.project.journalApp.Service;

import net.project.journalApp.api_response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.ServerEndpoint;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String apiKey = "xxxxxxxxxxxxxxxxxxxxxx";
    private static final String apiUrl = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    public WeatherResponse getWeather(String city) {

        String finalApi = apiUrl.replace("API_KEY", apiKey).replace("CITY", city);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET,null, WeatherResponse.class);

       WeatherResponse body= response.getBody();
       return body;
    }
}
