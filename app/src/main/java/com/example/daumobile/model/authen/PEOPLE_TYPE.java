package com.example.daumobile.model.authen;

public enum PEOPLE_TYPE {
    STUDENT(0), TEACHER(1), ADMIN(2);
    private int value = 0;

    PEOPLE_TYPE(final int newValue){
        value = newValue;
    }
    public int getValue() {
        return value;
    }
}