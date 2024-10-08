package com.example.lib.controller;

import com.example.lib.dto.BranchDto;
import com.example.lib.model.Branch;
import com.example.lib.service.branchService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class branchController {

    @Autowired
    private branchService branchServicee;
    @PostMapping("/cbranch")
    public ResponseEntity<Branch> createBranch(@RequestBody BranchDto branchdto) {
        Branch createdBranch = branchServicee.createBranch(branchdto);

        // Return the created branch along with HTTP 201 Created status
        return new ResponseEntity<>(createdBranch, HttpStatus.CREATED);
    }

    @GetMapping("/branches")
    @ResponseBody
    public List<Branch> getBranchs (HttpServletResponse httpServletResponse) {
        if(branchServicee.getAllBranches() == null)
        {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        return branchServicee.getAllBranches();
    }
}
