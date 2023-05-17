package studentgradingsystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class Student implements Serializable{
  private  int std_id;  
  private  String std_no;
  private  String std_name;
  private  String std_surname;
  private  String gender;
  private  String nationality;
  private  String birthday;

    public Student(int std_id, String std_no, String std_name, String std_surname, String gender, String nationality, String birthday) {
        this.std_id = std_id;
        this.std_no = std_no;
        this.std_name = std_name;
        this.std_surname = std_surname;
        this.gender = gender;
        this.nationality = nationality;
        this.birthday = birthday;
    }

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }
 
    public String getStd_no() {
        return std_no;
    }

    public void setStd_no(String std_no) {
        this.std_no = std_no;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public String getStd_surname() {
        return std_surname;
    }

    public void setStd_surname(String std_surname) {
        this.std_surname = std_surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

