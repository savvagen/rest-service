package com.example.jakson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {

    private @Getter @Setter String status;
    private @Getter @Setter TestUser value;

    public Status() {
    }

}