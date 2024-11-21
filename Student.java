package com.example.demo;

public class Student {
    private String name;
    private String fatherName;
    private String CNIC;
    private String gender;
    private String dateOfBirth;
    private String City;

    public Student(String name, String fatherName, String CNIC, String gender, String dateOfBirth, String city) {
        this.name = name;
        this.fatherName = fatherName;
        this.CNIC = CNIC;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        City = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", CNIC='" + CNIC + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}

