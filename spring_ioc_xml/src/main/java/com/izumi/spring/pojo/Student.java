package com.izumi.spring.pojo;

import java.util.Arrays;

public class Student implements Person {
    private Integer sid;
    private String sname;
    private Integer age;
    private String gender;
    private Double score;
    private Clazz clazz;
    private String[] hobby;

    public Student() {
    }

    public Student(Integer sid, String sname, Integer age, String gender, Double score, Clazz clazz, String[] hobby) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.gender = gender;
        this.score = score;
        this.clazz = clazz;
        this.hobby = hobby;
    }

    public Student(String s, String s2, String age, String gender) {
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                ", clazz=" + clazz +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }
}
