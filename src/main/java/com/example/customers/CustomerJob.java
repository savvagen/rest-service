package com.example.customers;


import com.example.jobs.Job;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;




@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Customer job")
public class CustomerJob {


    private @Getter @Setter Customer customer;
    private @Getter @Setter Job job;

    public CustomerJob(){
    }


}
