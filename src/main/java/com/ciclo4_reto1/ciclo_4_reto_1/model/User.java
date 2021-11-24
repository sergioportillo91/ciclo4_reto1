package com.ciclo4_reto1.ciclo_4_reto_1.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "user",indexes = @Index(name = "indx_email",columnList = "user_email",unique = true))
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Column(name = "user_email",nullable = false,length = 50)
    private String email;
    @NonNull
    @Column(name = "user_password",nullable = false,length = 50)
    private String password;
    @NonNull
    @Column(name = "user_name",nullable = false,length = 80)
    private String name;
}
