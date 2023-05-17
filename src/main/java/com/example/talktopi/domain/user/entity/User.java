package com.example.talktopi.domain.user.entity;

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
}
