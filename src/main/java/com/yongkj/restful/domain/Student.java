package com.yongkj.restful.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="student")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Student {

	@Id	//主键id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//主键生成策略
	@Column(name="sid")//数据库字段名
    private Integer sid;
	
	@Column(name="sname")
    private String sname;
	
	@Column(name="score")
    private Integer score;
	
	@Column(name="address")
    private String address;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
