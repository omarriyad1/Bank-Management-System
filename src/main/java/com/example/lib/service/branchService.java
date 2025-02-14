package com.example.lib.service;

import com.example.lib.dto.BranchDto;
import com.example.lib.model.Branch;
import com.example.lib.model.User;
import com.example.lib.repository.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class branchService {
    @Autowired
    private BranchRepo branchRepository ;
    public Branch createBranch(BranchDto branchDto) {
        Branch branch1 = new Branch();
        branchDto.setBranchName(branchDto.getBranchName());
        if(branchDto.getBranchCode() !=null)
        {
            branchDto.setBranchCode(branchDto.getBranchCode());
        }
        branchDto.setAddress(branchDto.getAddress());
        branch1.setAddress(branchDto.getAddress());
        branch1.setBranchName(branchDto.getBranchName());
        branch1.setBranchCode(branchDto.getBranchCode());

        return branchRepository.save(branch1) ;
    }
    public List<Branch> getAllBranches() {
     return branchRepository.findAll();
    }
//    public List<User> getBranchUsers(String branchCode) {
//        return branchRepository.existsBranchByBranchCode(branchCode);
//    }
    public Branch getBranch(String branchCode) {
        return branchRepository.findBranchByBranchCodeEquals(branchCode);
    }

}
