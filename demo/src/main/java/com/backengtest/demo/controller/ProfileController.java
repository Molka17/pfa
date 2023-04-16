package com.backengtest.demo.controller;

import com.backengtest.demo.dto.ProjectDto;
import com.backengtest.demo.model.Profile;
import com.backengtest.demo.service.ProfileService;
import com.backengtest.demo.service.ProjectServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/profile")
@Slf4j
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(profileService.getProfile(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id,@RequestBody Profile profile) {
        Profile updatedProjectDto = profileService.updateProfile(id,profile);
        return ResponseEntity.ok().body(updatedProjectDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Profile> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}
