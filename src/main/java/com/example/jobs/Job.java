package com.example.jobs;


import com.example.customers.Customer;
import com.example.customers.CustomerRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Data
@Entity
@Table(name = "customer_jobs")
@ApiModel("Jobs")
public class Job {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(dataType = "integer", value = "Job Id")
    private @Getter @Setter int job_id;

    @ApiModelProperty(dataType = "string", value = "Customer position")
    private @Getter @Setter String position;

    @JsonIgnore
    @ApiModelProperty(dataType = "integer", value = "Customer salary")
    private @Getter @Setter int salary;

    @ApiModelProperty(dataType = "string", value = "Job responsibilities")
    private @Getter @Setter String responsibilities;

    @ApiModelProperty(dataType = "integer", value = "Years on position")
    private @Getter @Setter int duration;

    @ApiModelProperty(dataType = "integer", value = "Customer Id")
    private @Getter @Setter Integer customer_id;


    public Job(){ }


}
