package weatherrestapi.weather.webclient.weather;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import weatherrestapi.weather.model.WeatherCurrentDTO;
import weatherrestapi.weather.model.WeatherDTO;
import weatherrestapi.weather.webclient.weather.dto.OpenWeatherDTO;
import weatherrestapi.weather.webclient.weather.dto2.OpenWeatherCurrentDTO;
/* Utworzenie klienta HTTP z wykorzystaniem Spring WebFlux*/
@Component
public class WeatherClient {

    private final String WEATHER_URL="https://api.openweathermap.org/data/2.5/";
    private final String ApiKey="7795fc48147d80c5759e47e5b3c09501";

    private WebClient webClient=WebClient.create();

    public WeatherDTO getWeatherForCity(String city){

       OpenWeatherDTO openWeatherDTO=callGetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=pl",
               OpenWeatherDTO.class,city,ApiKey);

       return WeatherDTO.builder()
               .temperature(openWeatherDTO.getMain().getTemp())
               .pressure(openWeatherDTO.getMain().getPressure())
              .humidity(openWeatherDTO.getMain().getHumidity())
               .Windspeed(openWeatherDTO.getWind().getSpeed())
               .type(openWeatherDTO.getSys().getType())
               .id(openWeatherDTO.getSys().getId())
               .country(openWeatherDTO.getSys().getCountry())
               .name(openWeatherDTO.getName())
               .szerokosc_Geograficzna(openWeatherDTO.getCoord().getLat())
               .dlugosc_Geograficzna(openWeatherDTO.getCoord().getLon())
               .build();

    }

    public String getWeatherWebFlux(String city){
        return callGetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=pl",
                String.class,city,ApiKey);
    }


    public WeatherCurrentDTO getForecast(double lat,double lon){
        OpenWeatherCurrentDTO openWeatherCurrentDTO= callGetMethod("onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&appid={apiKey}&units=metric&lang=pl",
                OpenWeatherCurrentDTO.class,lat,lon,ApiKey);

        return WeatherCurrentDTO.builder()
                .temperature(openWeatherCurrentDTO.getCurrent().getTemp())
                .feels_like(openWeatherCurrentDTO.getCurrent().getFeels_like())
                .pressure(openWeatherCurrentDTO.getCurrent().getPressure())
                .humidity(openWeatherCurrentDTO.getCurrent().getHumidity())
                .uvi(openWeatherCurrentDTO.getCurrent().getUvi())
                .Wind_speed(openWeatherCurrentDTO.getCurrent().getWind_speed())
                .build();
    }


    public <T> T callGetMethod(String url,Class<T> responseType,Object ...objects){
        return webClient.get()
                .uri(WEATHER_URL+url,objects)
                .retrieve()
                .bodyToMono(responseType)
                .block();
    }
}
