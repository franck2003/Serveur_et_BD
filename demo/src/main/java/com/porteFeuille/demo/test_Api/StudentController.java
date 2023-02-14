package com.porteFeuille.demo.modèle;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(
        produces = "application/json",
        method = {RequestMethod.GET, RequestMethod.PUT})

public class StudentController {

    public static final String base = "http:8010/localhost";

    protected StudentRepositories studentRepositories;
    public void StudentService(StudentRepositories studentRepositories){

        this.studentRepositories = studentRepositories;
    }

    public StudentController(StudentRepositories studentRepositories) {
        this.studentRepositories = studentRepositories;
    }


    @GetMapping(value = "/tostring")
    public String toString() {
        return "ta mère";
    }

    @GetMapping("/mama")
    public List<Student> number() {
        List<Student> list = new ArrayList<>();
        Student a = new Student(1L, "papa", 154, 154);
        Student b = new Student(1L, "mama", 154, 154);
        Student c = new Student(1L, "franck", 154, 154);
        Student d = new Student(1L, "audrey", 154, 154);
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        return list;
    }
    @PostMapping("/requestSend")
    public String requestSend(){
        return "hello world";
    }

}
