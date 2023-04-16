package com.backengtest.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "bio")
    private String bio;
    @Column(name = "skills")
    private String skills;
    @Column(name = "experience")
    private String experience;
    @Column(name = "about_me")
    private String aboutMe;
    @Lob
    @Column(name = "profile_picture", nullable = true)
    private byte[] profilePic;
    @Lob
    @Column(name = "cover_picture", nullable = true)
    private byte[] coverPic;
}
