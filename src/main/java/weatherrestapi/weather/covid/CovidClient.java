package weatherrestapi.weather.covid;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import weatherrestapi.weather.model.CovidDTO;
import weatherrestapi.weather.webclient.weather.dto.OpenCovid19DTO;
import lombok.Builder;

@Component
public class CovidClient {

    private final String URL_COVID="https://covidtrackerapi.bsg.ox.ac.uk/api/v2/stringency/";
    private RestTemplate restTemplate=new RestTemplate();

    /*
    public CovidDTO getCovidStatsDate(String beginDate, String endDate){

        OpenCovid19DTO openCovid19DTO=callGetMethod(URL_COVID+"date-range/{YYYY-MM-DD}/{YYYY-MM-DD}",OpenCovid19DTO.class,
                beginDate,endDate);

        return CovidDTO.builder()
                .minimumDeaths(openCovid19DTO.getDeaths().getMinDeaths())
                .maximumDeaths(openCovid19DTO.getDeaths().getMaxDeaths())
                .maximumStrignency(openCovid19DTO.getStrignency().getMaxStrignency())
                .maximumCasesConfirmed(openCovid19DTO.getConfirmed().getMaxCasesConfirmed())
                .build();

    }
    */


    public String getCovidStatsDate(String beginDate,String endDate){
        return callGetMethod(URL_COVID+"date-range/{YYYY-MM-DD}/{YYYY-MM-DD}",String.class,
                beginDate,endDate);
    }


    public String getCovidStatsForCountry(String countryCode,String dateTime){
        return callGetMethod(URL_COVID+"actions/{ALPHA-3}/{YYYY-MM-DD}",String.class,
                countryCode,dateTime);

    }

    //Metoda Generyczna przyjmujemy dowolony typ zwracany może to być String,Integer lub
    //nasz typ utworzony
    public <T> T callGetMethod(String url,Class<T> responseType,Object... objects){
        return restTemplate.getForObject(url,responseType,objects);
    }
}
