package com.hami.learningenglishtabasom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String city;
    @NotNull
    private String email;
    @NotNull
    private String phone;

    @Column(name = "find_me")
    @NotNull
    private String findMe;
    @NotNull
    private String message;
}
