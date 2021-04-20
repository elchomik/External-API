package weatherrestapi.weather.webclient.weather.dto;

import lombok.Getter;

@Getter
public class OpenCovid19DTO {

    private OpenCovidDeathsDTO deaths;
    private OpenCovidCasesConfirmedDTO confirmed;
    private OpenCovidStrignencyDTO strignency;


}
