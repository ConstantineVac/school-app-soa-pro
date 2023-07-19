package gr.aueb.cf.schoolapp.dto;

import java.util.Date;

public class StudentUpdateDTO extends BaseDTO{
    private String firstname;
    private String lastname;
    private String gender;
    private Date birthdate;
    private CityUpdateDTO city;
    private UserUpdateDTO user;

    public StudentUpdateDTO() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public CityUpdateDTO getCity() {
        return city;
    }

    public void setCity(CityUpdateDTO city) {
        this.city = city;
    }

    public UserUpdateDTO getUser() {
        return user;
    }

    public void setUser(UserUpdateDTO user) {
        this.user = user;
    }
}
