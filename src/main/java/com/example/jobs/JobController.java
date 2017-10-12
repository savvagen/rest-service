package com.example.jobs;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping(path = "/jobs")
public class JobController {


    @Autowired
    JobRepository jobRepository;


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Iterable<Job> getJobs(){
        return jobRepository.findAll();
    }


}
