package gr.aueb.cf.schoolapp.dto;

import java.util.Date;

public class MeetingInsertDTO {
    private TeacherInsertDTO teacher;
    private StudentInsertDTO student;
    private String meetingRoom;
    private Date meetingDate;

    public MeetingInsertDTO() {
    }

    public TeacherInsertDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherInsertDTO teacher) {
        this.teacher = teacher;
    }

    public StudentInsertDTO getStudent() {
        return student;
    }

    public void setStudent(StudentInsertDTO student) {
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
