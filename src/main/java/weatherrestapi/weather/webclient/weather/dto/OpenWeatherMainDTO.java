package weatherrestapi.weather.webclient.weather.dto;

import lombok.Getter;

@Getter
public class OpenWeatherMainDTO {
    private float temp;
    private int pressure;
    private int humidity;
}
