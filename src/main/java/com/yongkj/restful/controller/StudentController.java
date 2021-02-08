package com.yongkj.restful.controller;

import com.yongkj.restful.domain.Student;
import com.yongkj.restful.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @ResponseBody
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> getAllStudent() {
        List<Student> studenstList = studentService.getAllStudent();
        return studenstList;
    }

    @ResponseBody
    @RequestMapping(value = "/student/{sid}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("sid") Integer sid) {
        Student student = studentService.getStudentById(sid);
        return student;
    }

    @ResponseBody
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public List<Student> addStudent(String sname, Integer score, String address) {
        if(sname != null && score != null && address != null) {
            Student student = new Student();
            student.setSname(sname);
            student.setScore(score);
            student.setAddress(address);
            studentService.addStudent(student);
        }

        List<Student> studenstList = studentService.getAllStudent();
        return studenstList;
    }

    @ResponseBody
    @RequestMapping(value = "/student/{sid}", method = RequestMethod.PUT)
    public List<Student> modStudentById(@PathVariable("sid") Integer sid, String sname, Integer score, String address) {
        if(sname != null && score != null && address != null) {
            Student student = new Student();
            student.setSid(sid);
            student.setSname(sname);
            student.setScore(score);
            student.setAddress(address);
            studentService.modStudentById(student);
        }

        List<Student> studenstList = studentService.getAllStudent();
        return studenstList;
    }

    @ResponseBody
    @RequestMapping(value = "/student/{sid}", method = RequestMethod.DELETE)
    public List<Student> delStudentById(@PathVariable("sid") Integer sid) {
        studentService.delStudentById(sid);

        List<Student> studenstList = studentService.getAllStudent();
        return studenstList;
    }

}
