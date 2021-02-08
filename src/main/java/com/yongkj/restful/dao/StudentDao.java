package com.yongkj.restful.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yongkj.restful.domain.Student;

public interface StudentDao  extends JpaRepository<Student,Integer> {

}
