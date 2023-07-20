package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.IMeetingDAO;
import gr.aueb.cf.schoolapp.dao.exceptions.MeetingDAOException;
import gr.aueb.cf.schoolapp.dto.MeetingInsertDTO;
import gr.aueb.cf.schoolapp.dto.MeetingUpdateDTO;
import gr.aueb.cf.schoolapp.model.Meeting;
import gr.aueb.cf.schoolapp.service.exceptions.MeetingNotFoundException;

import java.util.List;

public class MeetingServiceImpl implements IMeetingService {
    private IMeetingDAO meetingDAO;

    public MeetingServiceImpl(IMeetingDAO meetingDAO) {
        this.meetingDAO = meetingDAO;
    }

    @Override
    public Meeting insertMeeting(MeetingInsertDTO dto) throws MeetingDAOException {
        if (dto == null) return null;
        Meeting meeting;
        try {
            meeting = map(dto);
            return meetingDAO.insert(meeting);
        } catch (MeetingDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Meeting updateMeeting(MeetingUpdateDTO dto) throws MeetingDAOException, MeetingNotFoundException {
        if (dto == null) return null;
        Meeting meeting;
        try {
            meeting = map(dto);

            if (meetingDAO.getById(meeting.getId()) == null) {
                throw new MeetingNotFoundException(meeting);
            }

            return meetingDAO.update(meeting);
        } catch (MeetingDAOException | MeetingNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteMeeting(int id) throws MeetingDAOException, MeetingNotFoundException {
        Meeting meeting;
        try {
            meeting = meetingDAO.getById(id);

            if (meeting == null) {
                throw new MeetingNotFoundException("Meeting with id: " + id + " was not found");
            }

            meetingDAO.delete(id);
        } catch (MeetingDAOException | MeetingNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Meeting> getMeetingsByMeetingRoom(String meetingRoom) throws MeetingDAOException {
        List<Meeting> meetings;
        try {
            meetings = meetingDAO.getByMeetingRoom(meetingRoom);
            return meetings;
        } catch (MeetingDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Meeting getMeetingById(int id) throws MeetingDAOException, MeetingNotFoundException {
        Meeting meeting;
        try {
            meeting = meetingDAO.getById(id);
            if (meeting == null) {
                throw new MeetingNotFoundException("Search Error: Meeting with id:" + id + " was not found");
            }
            return meeting;
        } catch (MeetingDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private Meeting map(MeetingInsertDTO dto) {
        return new Meeting(null, dto.getMeetingRoom(), dto.getMeetingDate());
    }

    private Meeting map(MeetingUpdateDTO dto) {
        return new Meeting(dto.getId(), dto.getMeetingRoom(), dto.getMeetingDate());
    }
}
