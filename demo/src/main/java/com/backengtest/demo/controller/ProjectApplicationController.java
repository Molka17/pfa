package com.backengtest.demo.controller;

import com.backengtest.demo.dto.ProjectApplicationDto;
import com.backengtest.demo.service.ProjectApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apply")
@Slf4j
public class ProjectApplicationController {
    private final ProjectApplicationService projectService;

    public ProjectApplicationController(ProjectApplicationService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectApplicationDto> getProject(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(projectService.getProjectById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProjectApplicationDto>> getAllProjects() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(projectService.getAllProjects());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectApplicationDto> updateProject(@PathVariable Long id,@RequestBody ProjectApplicationDto projectDto) {
        ProjectApplicationDto updatedProjectDto = projectService.updateProject(id,projectDto);
        return ResponseEntity.ok().body(updatedProjectDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectApplicationDto> postulate(@PathVariable Long id, @RequestBody ProjectApplicationDto projectDto) {
        ProjectApplicationDto project = projectService.postulate(id,projectDto);
        return ResponseEntity.ok().body(project);
    }
}
