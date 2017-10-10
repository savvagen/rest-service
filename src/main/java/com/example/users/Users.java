package com.example.users;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@ApiModel("Customers")
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(dataType = "integer", value = "Customer ID")
    private @Getter @Setter Integer user_id;

    @ApiModelProperty(dataType = "string", value = "Customer nickName")
    private @Getter @Setter String username;
    private @Getter @Setter String email;
    private @Getter @Setter String password;
    private @Getter @Setter String fullname;

}
