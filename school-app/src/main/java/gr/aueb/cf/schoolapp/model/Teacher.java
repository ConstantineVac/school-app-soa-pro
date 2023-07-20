package gr.aueb.cf.schoolapp.model;

public class Teacher {
    private Integer id;
    private String firstname;
    private String lastname;
    private Integer ssn;
    private Integer userId;
    private Integer specialityId;

    public Teacher() {}

    public Teacher(Integer id, String firstname, String lastname, Integer ssn, Integer userId, Integer specialityId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
        this.userId = userId;
        this.specialityId = specialityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getSsn() {
        if (ssn == null) {
            // Handle the case when ssn is null, e.g., throw an exception or return a default value
            // throw new IllegalStateException("SSN is not set for this teacher");
            return 0;
        }
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", ssn=" + ssn +
                '}';
    }
}
