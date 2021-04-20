package weatherrestapi.weather.webclient.weather.dto2;

import lombok.Getter;

@Getter
public class OpenWeatherCurrent {
    private float temp;
    private float feels_like;
    private int pressure;
    private int humidity;
    private float uvi;
    private float wind_speed;


}
