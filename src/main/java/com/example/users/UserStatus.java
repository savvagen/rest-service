package com.example.users;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Status")
public class UserStatus {

    private @Getter @Setter String status;
    private @Getter @Setter Users value;

    public UserStatus() {
    }

}