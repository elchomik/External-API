package weatherrestapi.weather.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import weatherrestapi.weather.jobsclient.JobsClient;
import weatherrestapi.weather.model.JobsDTO;

@Service
@Slf4j
@RequiredArgsConstructor
public class JobsService {

    private final JobsClient jobsClient;
    public JobsDTO getJobs(){
      /* String webresponse2=jobsClient.getJobs("pl");
        log.info(webresponse2);*/
        return jobsClient.getAdzunaJobs("pl");
    }


}
