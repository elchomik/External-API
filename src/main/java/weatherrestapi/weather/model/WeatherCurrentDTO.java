package weatherrestapi.weather.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WeatherCurrentDTO {
    private float temperature;
    private float feels_like;
    private int pressure;
    private int humidity;
    private float uvi;
    private float Wind_speed;
}
