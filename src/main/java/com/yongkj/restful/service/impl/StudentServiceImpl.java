package com.yongkj.restful.service.impl;

import com.yongkj.restful.dao.StudentDao;
import com.yongkj.restful.domain.Student;
import com.yongkj.restful.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentMapper;

    @Override
    @Transactional(readOnly = true, timeout = 3, isolation = Isolation.REPEATABLE_READ)
    public Student getStudentById(Integer sid) {
        return studentMapper.getOne(sid);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentMapper.findAll();
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.save(student);
    }

    @Override
    public void modStudentById(Student student) {
        studentMapper.save(student);
    }

    @Override
    public void delStudentById(Integer sid) {
        studentMapper.deleteById(sid);
    }


/*    @Transactional
    public void checkOut(){
        studentMapper.updateStcok();
        studentMapper.updateBalance();
    }*/
}
