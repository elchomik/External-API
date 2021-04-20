package weatherrestapi.weather.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherDTO {

    private float temperature;
    private int pressure;
    private int humidity;
    private float Windspeed;
    private int type;
    private int id;
    private String country;
    private String name;
    private double szerokosc_Geograficzna;
    private double dlugosc_Geograficzna;
}
