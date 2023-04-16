package com.backengtest.demo.service;

import com.backengtest.demo.dto.ProjectApplicationDto;
import com.backengtest.demo.dto.UserDto;
import com.backengtest.demo.exception.ProjectNotFoundException;
import com.backengtest.demo.mapper.ProjectApplicationMapper;
import com.backengtest.demo.model.Project;
import com.backengtest.demo.model.ProjectApplication;
import com.backengtest.demo.model.ProjectDomain;
import com.backengtest.demo.model.User;
import com.backengtest.demo.repository.ProjectApplicationRepository;
import com.backengtest.demo.repository.ProjectDomainRepo;
import com.backengtest.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@AllArgsConstructor
public class ProjectApplicationService {
    private final ProjectApplicationRepository projectRepo;
    private final ProjectDomainRepo projectDomainRepo;
    private final UserRepository userRepository;
    private final ProjectApplicationMapper projectApplicationMapper;
    private final AuthService authService;

    @Transactional
    public ProjectApplicationDto createProject(Project project) {
        ProjectApplication projectApplication = (ProjectApplication) project;
        projectApplication.setHiring(true);
        ProjectApplication save = projectRepo.save(projectApplication);
        return projectApplicationMapper.mapProjectToDto(save);
    }

    public ProjectApplicationDto updateProject(Long id,ProjectApplicationDto projectDto) {
        ProjectDomain projectDomain = projectDomainRepo.findById(projectDto.getProjectDomainId())
                .orElseThrow(() -> new IllegalArgumentException("Project domain not found"));
        ProjectApplication project = projectRepo.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id "+ id + " not found"));
        project.setProjectDomain(projectDomain);
        project.setTitle(projectDto.getTitle());
        project.setDescription(projectDto.getDescription());
        project.setPayment(projectDto.getPayment());
        project.setActive(projectDto.getActive());
        project.setDate(projectDto.getDate());
        project.setHiring(projectDto.getHiring());
        return projectApplicationMapper.mapProjectToDto(projectRepo.save(project));
    }

    @Transactional
    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }

    @Transactional
    public ProjectApplicationDto getProjectById(Long id) {
        ProjectApplication project = projectRepo.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id " + id + " not found"));
        return projectApplicationMapper.mapProjectToDto(project);
    }

    @Transactional
    public List<ProjectApplicationDto> getAllProjects() {
        return   projectRepo.findAll()
                .stream()
                .map(projectApplicationMapper::mapProjectToDto)
                .collect(toList());
    }

    @Transactional
    public ProjectApplicationDto postulate(Long id ,ProjectApplicationDto projectDto){
        ProjectDomain projectDomain = projectDomainRepo.findById(projectDto.getProjectDomainId())
                .orElseThrow(() -> new IllegalArgumentException("Project domain not found"));
        ProjectApplication project = projectApplicationMapper.mapProjectDtoToEntity(projectDto, projectDomain);
        project.getUsers().add(authService.getCurrentUser());
        return projectApplicationMapper.mapProjectToDto(projectRepo.save(project));
    }
}
