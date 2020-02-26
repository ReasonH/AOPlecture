package com.practice.aoplec.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String email;

    @Column
    private String name;

    @Builder
    public User(String email, String name){
        this.email = email;
        this.name = name;
    }
}
