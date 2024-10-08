package com.example.lib.repository;

import com.example.lib.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepo extends JpaRepository<Branch, Long> {
}
