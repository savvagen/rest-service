package com.example.customers;

import com.example.users.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Status")
public class CustomerStatus {

    private @Getter @Setter boolean status;
    private @Getter @Setter String message;
    private @Getter @Setter Customer value;


    public CustomerStatus() {
    }

}