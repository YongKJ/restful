package com.yongkj.restful.service;

import com.yongkj.restful.domain.Student;

import java.util.List;

public interface StudentService {

    Student getStudentById(Integer sid);

    List<Student> getAllStudent();

    void addStudent(Student student);

    void modStudentById(Student student);

    void delStudentById(Integer sid);

}
