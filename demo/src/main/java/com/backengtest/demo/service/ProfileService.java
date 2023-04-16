package com.backengtest.demo.service;


import com.backengtest.demo.exception.SpringFreelanciniException;
import com.backengtest.demo.model.Profile;
import com.backengtest.demo.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Transactional
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Transactional
    public Profile getProfile(Long id){
        return profileRepository.findById(id)
                .orElseThrow(() -> new SpringFreelanciniException("User with id " + id + " is not found"));
    }

    @Transactional
    public Profile updateProfile(Long id,Profile profile){
        Profile existingProfile = profileRepository.findById(id)
                .orElseThrow(() -> new SpringFreelanciniException("Project with id " + id + " not found"));
        existingProfile.setBio(profile.getBio());
        existingProfile.setExperience(profile.getExperience());
        existingProfile.setSkills(profile.getSkills());
        existingProfile.setAboutMe(profile.getAboutMe());
        existingProfile.setProfilePic(profile.getProfilePic());
        existingProfile.setCoverPic(profile.getCoverPic());
        return profileRepository.save(existingProfile);
    }

    @Transactional
    public void deleteProfile(Long id) { profileRepository.deleteById(id); }
}
