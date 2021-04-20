package weatherrestapi.weather.jobsclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import weatherrestapi.weather.model.JobsDTO;
import weatherrestapi.weather.webclient.weather.dto2.AdzunaDTO;

@Component
public class JobsClient {

    private final String APP_ID="d6e4fd08";
    private final String API_Key="363099856d64eba5806158a1faea0c49";
    private final String JOBS_URL="https://api.adzuna.com/v1/api/jobs/";
    WebClient jobsClient=WebClient.create(JOBS_URL);

       /*
        String respond2=restTemplate.getForObject("https://api.adzuna.com/v1/api/jobs/gb/top_companies?app_id={appId}&app_key={appKey}&what={title}&location0={loc}",
                String.class,"d6e4fd08","363099856d64eba5806158a1faea0c49","java","UK");
*/
    public String getJobs(String country){
        return callAPIGetMethod("{country}/search/1?app_id={YOUR_APP_ID}&app_key={YOUR_APP_KEY}",
                String.class,country,APP_ID,API_Key);
    }

    public JobsDTO getAdzunaJobs(String country){
        AdzunaDTO adzunaDTO=callAPIGetMethod("{country}/search/1?app_id={YOUR_APP_ID}&app_key={YOUR_APP_KEY}",
                AdzunaDTO.class,country,APP_ID,API_Key);

        return JobsDTO.builder()
                .nazwa(adzunaDTO.getTitle())
                .build();
    }

    public <T> T callAPIGetMethod(String url,Class<T> responseType,Object ...objects){
        return jobsClient.get()
                .uri(url,objects)
                .retrieve()
                .bodyToMono(responseType)
                .block();
    }
}
