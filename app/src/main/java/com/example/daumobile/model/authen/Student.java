package com.example.daumobile.model.authen;

import java.io.Serializable;
import java.util.Objects;

public class Student extends People  implements Serializable {
    String lopHoc;

    public String getLopHoc() {
        return lopHoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(lopHoc, student.lopHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lopHoc);
    }

    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
    }

    public Student(String lopHoc) {
        this.lopHoc = lopHoc;
    }

    public Student(String id, String password, String name, String address, String numberphone, String lopHoc) {
        super(id, password, PEOPLE_TYPE.STUDENT.getValue(), name, address, numberphone);
        this.lopHoc = lopHoc;
    }

    public Student() {
    }

    @Override
    public int getType() {
        return PEOPLE_TYPE.STUDENT.getValue();
    }
}
