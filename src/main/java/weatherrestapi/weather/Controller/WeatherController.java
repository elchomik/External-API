package weatherrestapi.weather.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import weatherrestapi.weather.model.WeatherCurrentDTO;
import weatherrestapi.weather.model.WeatherDTO;
import weatherrestapi.weather.service.WeatherService;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherDTO getWeather(){
        return weatherService.getWeather();
    }

    @GetMapping("/webflux")
    public String getWeatherWebFlux(){
        return weatherService.getWeatherWebFlux();
    }

    @GetMapping("/forecast")
    public WeatherCurrentDTO getWeatherForecast(){
        return weatherService.getWeatherForecast();
    }


}
