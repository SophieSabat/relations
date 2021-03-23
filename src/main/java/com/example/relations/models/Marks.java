package com.example.relations.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"student"})
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int mark;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Student student;



    public Marks(int mark) {
        this.mark = mark;
    }

    public Marks(int mark, Student student) {
        this.mark = mark;
        this.student = student;
    }
}
