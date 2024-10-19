package com.example.lib.repository;

import com.example.lib.model.Branch;
import com.example.lib.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface BranchRepo extends JpaRepository<Branch, Long> {
  //  List<User> existsBranchByBranchCode(String branchCode);

    Branch findBranchByBranchCodeEquals(String branchCode);

    Branch getBranchByBranchCode( String branchCode);
}
