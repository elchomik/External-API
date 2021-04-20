package weatherrestapi.weather.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weatherrestapi.weather.covid.CovidClient;
import weatherrestapi.weather.model.CovidDTO;

@Service
@Slf4j
@RequiredArgsConstructor
public class CovidService {


   private final CovidClient covidClient;


    public CovidDTO getCovidStats(){
   String responseFromCovidClient=covidClient.getCovidStatsDate("2020-06-11","2020-06-12");
    log.info(responseFromCovidClient);

  String responseFromCovidCountry=covidClient.getCovidStatsForCountry("POL","2020-12-25");
    log.info(responseFromCovidCountry);
return null;


    }


}
