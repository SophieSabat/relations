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
@ToString(exclude = {"marks", "teachers"})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private List<Marks> marks = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_teachers",
            joinColumns = {@JoinColumn(name = "students_id")},
            inverseJoinColumns = {@JoinColumn(name = "teachers_id")}
    )
    private List<Teacher> teachers = new ArrayList<>();



    public Student(String name) {
        this.name = name;
    }

    public Student(String name, List<Marks> marks) {
        this.name = name;
        this.marks = marks;
    }

    public Student(String name, List<Marks> marks, List<Teacher> teachers) {
        this.name = name;
        this.marks = marks;
        this.teachers = teachers;
    }
}
