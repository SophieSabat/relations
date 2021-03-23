package com.example.relations.controllers;

import com.example.relations.dao.StudentDAO;
import com.example.relations.models.Marks;
import com.example.relations.models.Student;
import com.example.relations.models.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentsController {

    private StudentDAO studentDAO;


    @GetMapping()
    public List<Student> getStudents() {
        return studentDAO.findAll();
    }

    @GetMapping("/save")
    public void save() {
        Student student = new Student();
        student.setName("vasya");
        List<Marks> marks = new ArrayList<>();
        marks.add(new Marks(4));
        marks.add(new Marks(5));
        student.setMarks(marks);

        studentDAO.save(student);
    }

    @GetMapping("/studentWithTeacher")
    public void studentWithTeacher() {
        Student student = new Student();
        student.setName("max");
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("olena vasulivna"));
        teachers.add(new Teacher("oleg petrovich"));
        student.setTeachers(teachers);
        studentDAO.save(student);
    }
}
