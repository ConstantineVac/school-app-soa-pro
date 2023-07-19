package gr.aueb.cf.schoolapp.model;

import java.util.Date;

public class Meeting {
    private Integer id;
    private String meetingRoom;
    private Date meetingDate;

    public Meeting() {
    }

    public Meeting(Integer id, String meetingRoom, Date meetingDate) {
        this.id = id;
        this.meetingRoom = meetingRoom;
        this.meetingDate = meetingDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", meetingRoom='" + meetingRoom + '\'' +
                ", meetingDate=" + meetingDate +
                '}';
    }
}
