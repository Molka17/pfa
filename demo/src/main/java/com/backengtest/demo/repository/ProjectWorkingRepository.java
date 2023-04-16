package com.backengtest.demo.repository;

import com.backengtest.demo.model.ProjectWorking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectWorkingRepository extends JpaRepository<ProjectWorking, Long> {
}
