package com.porteFeuille.demo.test_Api;

import com.porteFeuille.demo.modèle.Student;
import com.porteFeuille.demo.modèle.StudentRepositories;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

public class StudentService {


    protected final StudentRepositories studentRepositories;
    public StudentService(StudentRepositories studentRepositories){

        this.studentRepositories = studentRepositories;
    }

    public List<Student> getStudents(){
        return studentRepositories.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepositories.findById(student.getName());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepositories.save(student);
    }

}
