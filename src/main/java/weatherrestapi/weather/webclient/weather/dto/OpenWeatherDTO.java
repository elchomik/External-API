package weatherrestapi.weather.webclient.weather.dto;

import lombok.Getter;

@Getter
public class OpenWeatherDTO {
    private OpenWeatherMainDT mainO;
    private OpenWeatherWindDTO wind;
    private OpenWeatherSysDTO sys;
    private String name;
    private OpenWeatherCordDTO coord;
}
