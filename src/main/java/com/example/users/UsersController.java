package com.example.users;


import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/users")
@Api(tags = "My Users controller")
public class UsersController {


    @Autowired
    UserRepo usersRepository;


    @GetMapping(path="/add") // Map ONLY GET Requests
    //@PostMapping
    @ApiOperation(value = "Adds new customer")
    public @ResponseBody String addNewUser (@RequestParam String username,
                                            @RequestParam String email,
                                            @RequestParam String password,
                                            @RequestParam String fullname) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Users users = new Users();
        users.setUsername(username);
        users.setEmail(email);
        users.setPassword(password);
        users.setFullname(fullname);
        usersRepository.save(users);
        return "Saved";
    }


    @PostMapping(path = "/add")
    @ApiOperation(value = "Adds new customer")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 404, message = "Service not found"),
            @ApiResponse(code = 200, message = "Successful retrieval",
                    response = UserStatus.class, responseContainer = "User Status") })
    public @ResponseBody UserStatus createNewUser(@RequestBody Users user){
        UserStatus status = new UserStatus();
        Users savedUser = new Users();
        savedUser.setUser_id(user.getUser_id());
        savedUser.setUsername(user.getUsername());
        savedUser.setEmail(user.getEmail());
        savedUser.setPassword(user.getPassword());
        savedUser.setFullname(user.getFullname());
        usersRepository.save(savedUser);
        status.setStatus("Saved");
        status.setValue(savedUser);
        return status;
    }



    @GetMapping(path="/all")
    @ApiOperation(value = "Gets all customers", notes="Gets customers from DB",nickname = "getAllUsers")
    public @ResponseBody Iterable<Users> getAllUsers() {
        // This returns a JSON or XML with the users
        return usersRepository.findAll();
    }



    @GetMapping(path="/find")
    @ApiOperation(value = "Find customer")
    public @ResponseBody Users getUser(@ApiParam(value = "This is and customer ID") @RequestParam Integer id) {
        // This returns a JSON or XML with the users
        return usersRepository.findOne(id);
    }


    @GetMapping(path="/find/{id}")
    @ApiOperation(value = "Find customer")
    public @ResponseBody Users getUserById(@PathVariable(value = "id") Integer id) {
        // This returns a JSON or XML with the users
        return usersRepository.findOne(id);
    }


    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleting customer")
    public @ResponseBody UserStatus deleteUser(@PathVariable(value = "id") Integer id){
        UserStatus status = new UserStatus();
        Users users = usersRepository.findOne(id);
        Users deletedUser = new Users();
        deletedUser.setUser_id(users.getUser_id());
        deletedUser.setEmail(users.getEmail());
        deletedUser.setFullname(users.getFullname());
        deletedUser.setPassword(users.getPassword());
        deletedUser.setUsername(users.getUsername());
        usersRepository.delete(deletedUser);
        status.setStatus("deleted");
        status.setValue(deletedUser);
        return status;
    }






}
