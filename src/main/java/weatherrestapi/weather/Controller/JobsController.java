package weatherrestapi.weather.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import weatherrestapi.weather.model.JobsDTO;
import weatherrestapi.weather.service.JobsService;

@RestController
@RequiredArgsConstructor
public class JobsController {

    private final JobsService jobsService;

    @GetMapping("/jobs")
    public JobsDTO getJobs(){
        return jobsService.getJobs();
    }
}
