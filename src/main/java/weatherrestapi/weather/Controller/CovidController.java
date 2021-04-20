package weatherrestapi.weather.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import weatherrestapi.weather.model.CovidDTO;
import weatherrestapi.weather.service.CovidService;

@RestController
@RequiredArgsConstructor
public class CovidController {


    private final CovidService covidService;

    @GetMapping("/covid")
    public CovidDTO getCovidStats(){
        return covidService.getCovidStats();
    }

}
