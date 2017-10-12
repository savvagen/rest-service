package com.example.customers;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
@ApiModel("Customer")
public class Customer {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(dataType = "integer", value = "Customer Id")
    private @Getter @Setter int customer_id;

    @ApiModelProperty(dataType = "string", value = "Customer First Name")
    private @Getter @Setter String firstname;

    @ApiModelProperty(dataType = "string", value = "Customer Last Name")
    private @Getter @Setter String lastname;

    @Column(unique = true)
    @ApiModelProperty(dataType = "string", value = "Customer Email address")
    private @Getter @Setter String email;

    @ApiModelProperty(dataType = "string", value = "Customer password")
    private @Getter @Setter String password;

    @ApiModelProperty(dataType = "string", value = "Customer telephone")
    private @Getter @Setter String telephone;

    @JsonIgnore
    @ApiModelProperty(dataType = "string", value = "Registration date")
    private @Getter @Setter String reg_date;

    @ApiModelProperty(dataType = "int", value = "Customer age")
    private @Getter @Setter int age;


}
