package com.example.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisteredStatus {

    private @Getter @Setter boolean registered;
    private @Getter @Setter String message;

    public RegisteredStatus(){

    }


}
