package com.example.lib.service;

import com.example.lib.dto.UserDto;
import com.example.lib.model.Branch;
import com.example.lib.model.User;
import com.example.lib.repository.BranchRepo;
import com.example.lib.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BranchRepo branchRepo;  // Properly inject BranchRepo

    public User createUser(UserDto user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setAddress(user.getAddress());

        // Use branchRepo to fetch the branch by branch code
        Branch branch = branchRepo.getBranchByBranchCode(user.getBranchCode());
        newUser.setBranch(branch);

        newUser.setPhoneNumber(user.getPhoneNumber());

        return userRepo.save(newUser);  // Save the new user with branch
    }
}
