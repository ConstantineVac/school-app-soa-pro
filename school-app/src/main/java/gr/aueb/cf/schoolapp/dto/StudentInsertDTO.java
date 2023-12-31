package gr.aueb.cf.schoolapp.dto;

import java.util.Date;

public class StudentInsertDTO {
    private String firstname;
    private String lastname;
    private String gender;
    private Date birthdate;
    private CityInsertDTO city;
    private UserInsertDTO user;

    public StudentInsertDTO() {
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

    public CityInsertDTO getCity() {
        return city;
    }

    public void setCity(CityInsertDTO city) {
        this.city = city;
    }

    public UserInsertDTO getUser() {
        return user;
    }

    public void setUser(UserInsertDTO user) {
        this.user = user;
    }
}
