package weatherrestapi.weather.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CovidDTO {

    private int minimumDeaths;
    private int maximumDeaths;
    private int maximumStrignency;
    private int maximumCasesConfirmed;
}
