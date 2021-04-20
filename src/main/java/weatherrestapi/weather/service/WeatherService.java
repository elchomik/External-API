package weatherrestapi.weather.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import weatherrestapi.weather.model.WeatherCurrentDTO;
import weatherrestapi.weather.model.WeatherDTO;
import weatherrestapi.weather.webclient.weather.WeatherClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {


    private final WeatherClient weatherClient;


    public WeatherDTO getWeather(){
       //String response=weatherClient.getWeatherForCity("Lublin");
      /*log.info(response);
        response= weatherClient.getForecast(51,23);
        log.info(response);
*/

        return weatherClient.getWeatherForCity("Lublin");
    }

    public WeatherCurrentDTO getWeatherForecast(){
        return weatherClient.getForecast(51,23);
    }
    public String getWeatherWebFlux(){
        String responeJSON=weatherClient.getWeatherWebFlux("Lublin");
        log.info(responeJSON);
        return responeJSON;
    }


}
