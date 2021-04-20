package weatherrestapi.weather.webclient.weather;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import weatherrestapi.weather.model.WeatherDTO;
import weatherrestapi.weather.webclient.weather.dto.OpenWeatherDTO;

//Klasa korzystająca ze starszego rozwiązanie, ktore obecnie nie jest
//wspierane czyli korzystanie z klienta RestTemplate

@Component
public class WeatherClientRestTemplate {
    private final String WEATHER_URL="https://api.openweathermap.org/data/2.5/";
    private final String ApiKey="7795fc48147d80c5759e47e5b3c09501";

    private RestTemplate restTemplate=new RestTemplate();

    public WeatherDTO getWeather(String city){

        OpenWeatherDTO openWeatherDTO=callgetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=pl",
                OpenWeatherDTO.class,city,ApiKey);

        return WeatherDTO.builder()
                .temperature(openWeatherDTO.getMain().getTemp())
                .pressure(openWeatherDTO.getMain().getPressure())
                .humidity(openWeatherDTO.getMain().getHumidity())
                .Windspeed(openWeatherDTO.getWind().getSpeed())
                .build();

    }

    public String getForecast(double lat,double lon){

        return callgetMethod("onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&appid={apiKey}&units=metric&lang=pl",
                String.class,lat,lon,ApiKey);
    }

    //Metoda generyczna umożliwia nam zwracanie obiektów różnych typów, oraz
    //przyjmuje varargs jako parametr obsługujacy zapytanie do API

    public <T> T callgetMethod(String url,Class<T> responseType,Object ...objects){
    return restTemplate.getForObject(WEATHER_URL+url,responseType,objects);
    }
}
