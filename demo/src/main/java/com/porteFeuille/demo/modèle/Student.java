package com.porteFeuille.demo.modèle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name = "Student")

public class Student {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "student_sequence")

    @Column(name = "students", nullable = false)
    private Long students;

    private Long id;
    private String name;

    private int age;

    private int LocalDate;


    public Long getStudents() {
        return students;
    }

    public void setStudents(Long students) {
        this.students = students;
    }

    public Student() {
    }

    public Student(Long id, String name, int age, int localDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        LocalDate = localDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    //server.port - 8080
    public void setAge(int age) {
        this.age = age;
    }

    public void setLocalDate(int localDate) {
        LocalDate = localDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override

    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", LocalDate=" + LocalDate +
                '}';
    }

    public int getLocalDate() {
        return LocalDate;
    }
}
