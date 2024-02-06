package com.userupdate.userupdate.UserRepo;

import java.util.List;
import java.util.Optional;

import com.userupdate.userupdate.User.User;
import org.springframework.data.jpa.repository.JpaRepository;




import org.springframework.stereotype.Repository;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional <User> findById(int id);

    Optional <User> findByMobile(String mobile);
}