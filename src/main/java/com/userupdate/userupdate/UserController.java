package com.userupdate.userupdate;

import com.userupdate.userupdate.Service.userService;
import com.userupdate.userupdate.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private userService service;

    @PostMapping("/createUser")
    public User createBook(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/createUsers")
    public List<User> createBooks(@RequestBody List<User> users){
        return service.saveUsers(users);
    }

    @GetMapping("/retrieveUsers")
    public List<User> retrieveUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/retrieveUserById/{id}")
    public User retrieveUserById(@PathVariable int id) {
        return service.getUserById(id);
    }


    @PostMapping("/deleteUser")
    public String deleteUser(@RequestBody User user) {
        int id = user.getId();
        return service.deleteUser(id);
    }

    @PostMapping("/UserByNumber")
    public User UserByNumber(@RequestBody User user) {
        String mob = user.getMobile();
        return  service.getUsersByNumber(mob);
    }

    @PostMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

}