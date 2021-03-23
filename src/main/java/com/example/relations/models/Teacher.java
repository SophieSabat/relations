package com.example.relations.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"students"})
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "teachers")
    private List<Student> students = new ArrayList<>();


    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }
}
