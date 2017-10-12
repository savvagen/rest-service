package com.example.customers;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/customers")
@Api(value = "Customers")
public class CustomerController {


    @Autowired
    CustomerRepository customerRepository;





    @GetMapping
    @ApiOperation(value = "Gets all customers", notes="Gets customers from DB", nickname = "getAllCustomers")
    public @ResponseBody Iterable<Customer> getCustomers(){
        return customerRepository.findAll();
    }




    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get customer")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 404, message = "Service not found"),
            @ApiResponse(code = 200, message = "Successful retrieval",
                    response = Customer.class, responseContainer = "Customer credentials") })
    public Customer getCustomer(@PathVariable(value = "id") int id){
        return customerRepository.findOne(id);
    }




    @GetMapping(path = "/add")
    @ApiOperation(value = "Adds new customer")
    public @ResponseBody CustomerStatus addUser(@RequestParam String firstname,
                                  @RequestParam String lastname,
                                  @RequestParam String email,
                                  @RequestParam String password,
                                  @RequestParam String telephone,
                                  @RequestParam Integer age){
        Customer customer = new Customer();
        CustomerStatus status = new CustomerStatus();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setTelephone(telephone);
        customer.setAge(age);
        customerRepository.save(customer);
        if (customerRepository.findOneByEmail(email).getEmail() != null){
            status.setStatus(true);
            status.setMessage("User was registered successfully!");
            status.setValue(customer);
        } else {
            status.setStatus(false);
            status.setMessage("Error");
        }
        return status;
    }




    @PostMapping("/register")
    @ApiOperation(value = "Register new customer")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 404, message = "Service not found"),
            @ApiResponse(code = 200, message = "Successful retrieval",
                    response = CustomerStatus.class, responseContainer = "Customer Status") })
    public @ResponseBody CustomerStatus registerUser(@RequestBody Customer customer){
        Assert.notNull(customer);
        CustomerStatus status = new CustomerStatus();
        customerRepository.save(customer);
        if (customerRepository.findOneByEmail(customer.getEmail()).getEmail() != null){
            status.setStatus(true);
            status.setMessage("User was registered successfully!");
            status.setValue(customer);

        } else {
            status.setStatus(false);
            status.setMessage("Error");
        }
        return status;
    }




    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes customer")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 404, message = "Service not found"),
            @ApiResponse(code = 200, message = "Successful retrieval",
                    response = CustomerStatus.class, responseContainer = "Customer Status") })
    public @ResponseBody CustomerStatus deleteCustomer(@PathVariable(value = "id") Integer id){
        CustomerStatus status = new CustomerStatus();
        Customer customer = customerRepository.findOne(id);
        customerRepository.delete(id);
        status.setStatus(true);
        status.setValue(customer);
        status.setMessage("User was Deleted!");
        return status;
    }




}
