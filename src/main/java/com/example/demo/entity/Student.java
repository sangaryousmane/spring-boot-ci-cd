package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity(name = "Student")
@NoArgsConstructor
@Getter @Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @Embedded
    private Address address;


    public Student(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
