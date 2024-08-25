package com.example.capstone_3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(25) not null")
    private String username;
    @NotEmpty
    @Column(columnDefinition = "varchar(25) not null")
    private String password;
    @NotEmpty
    @Email
    @Column(columnDefinition = "varchar(25) not null")
    private String email;
    @NotEmpty
    @Pattern(regexp = "^(Admin|Customer)$")
    @Column(columnDefinition = "varchar(10) not null")
    private String role;
    private LocalDate registrationDate = LocalDate.now();
}
