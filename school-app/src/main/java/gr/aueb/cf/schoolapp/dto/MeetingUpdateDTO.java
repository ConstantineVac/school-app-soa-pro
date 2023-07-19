package gr.aueb.cf.schoolapp.dto;

import java.util.Date;

public class MeetingUpdateDTO extends BaseDTO{
    private TeacherUpdateDTO teacher;
    private StudentUpdateDTO student;
    private String meetingRoom;
    private Date meetingDate;

    public MeetingUpdateDTO() {
    }

    public TeacherUpdateDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherUpdateDTO teacher) {
        this.teacher = teacher;
    }

    public StudentUpdateDTO getStudent() {
        return student;
    }

    public void setStudent(StudentUpdateDTO student) {
        this.student = student;
    }

    public String getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(String meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }
}
