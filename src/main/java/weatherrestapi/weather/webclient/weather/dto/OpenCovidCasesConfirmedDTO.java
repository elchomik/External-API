package weatherrestapi.weather.webclient.weather.dto;

import lombok.Getter;

@Getter
public class OpenCovidCasesConfirmedDTO {
    private int minCasesConfirmed;
    private int maxCasesConfirmed;
}
