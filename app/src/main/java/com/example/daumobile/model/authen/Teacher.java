package com.example.daumobile.model.authen;

import java.io.Serializable;
import java.util.Objects;

public class Teacher extends People  implements Serializable {
    String monDay;

    public Teacher() {
    }

    public Teacher(String monDay) {
        this.monDay = monDay;
    }

    public Teacher(String id, String password,String name, String address, String numberphone, String monDay) {
        super(id, password, PEOPLE_TYPE.TEACHER.getValue(), name, address, numberphone);
        this.monDay = monDay;
    }

    @Override
    public int getType() {
        return PEOPLE_TYPE.TEACHER.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(monDay, teacher.monDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), monDay);
    }

    public String getMonDay() {
        return monDay;
    }

    public void setMonDay(String monDay) {
        this.monDay = monDay;
    }
}
