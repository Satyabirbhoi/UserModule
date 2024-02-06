package com.userupdate.userupdate.Service;


import java.util.List;

import com.userupdate.userupdate.User.User;
import com.userupdate.userupdate.UserRepo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class userService {

    @Autowired
    private UserRepo UserRepo;

    public User saveUser(User User) {
        return UserRepo.save(User);
    }

    public List<User> saveUsers(List<User> books){
        return UserRepo.saveAll(books);
    }

    public List<User> getAllUsers() {
        return UserRepo.findAll();
    }

    public User getUserById(int id) {
        return UserRepo.findById(id).orElse(null);
    }

    public User getUsersByNumber(String num){
        return  UserRepo.findByMobile(num).orElse(null);
    }

    public String deleteUser(int id) {
        UserRepo.deleteById(id);
        return "deleted user with id "+id;
    }

    public User updateUser(User User) {
        User existingUser = UserRepo.findById(User.getId()).orElse(null);
        existingUser.setMobile(User.getMobile());
        existingUser.setAddress(User.getAddress());
        existingUser.setAmount(User.getAmount());

        return UserRepo.save(existingUser);
    }

}