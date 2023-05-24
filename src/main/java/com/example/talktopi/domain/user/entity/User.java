package com.example.talktopi.domain.user.entity;

import com.example.talktopi.domain.user.controller.dto.request.EditProfileRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String email;

    @Column
    private String password;

    @Column(length = 6)
    private String gender;

    @Column
    private int age;

    @Column
    private String job;

    @Column(length = 4)
    private String mbti;

    @Column(length = 20)
    private String name;

    @Column(length = 999999999)
    private String profile_image;

    @Column
    private String hobby;

    @Column(length = 20)
    private String nickname;

    @Column
    private String address;

    @Column
    private String introduction;

    public void editProfile(EditProfileRequest request, String s3ImgName) {
        this.gender = request.getGender();
        this.age = request.getAge();
        this.job = request.getJob();
        this.mbti = request.getMbti();
        this.name = request.getName();
        this.profile_image = s3ImgName;
        this.hobby = request.getHobby();
        this.nickname = request.getNickname();
        this.address = request.getAddress();
        this.introduction = request.getIntroduction();
    }
}
