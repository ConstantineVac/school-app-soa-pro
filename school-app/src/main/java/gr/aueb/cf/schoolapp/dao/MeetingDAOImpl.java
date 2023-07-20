package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.dao.exceptions.MeetingDAOException;
import gr.aueb.cf.schoolapp.model.Meeting;
import gr.aueb.cf.schoolapp.service.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingDAOImpl implements IMeetingDAO {
    @Override
    public Meeting insert(Meeting meeting) throws MeetingDAOException {
        String sql = "INSERT INTO MEETINGS(MEETING_ROOM, MEETING_DATE) VALUES (?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, meeting.getMeetingRoom());
            ps.setDate(2, new java.sql.Date(meeting.getMeetingDate().getTime()));

            int n = ps.executeUpdate();
            if (n >= 1) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        meeting.setId(generatedKeys.getInt(1));
                    }
                }
                return meeting;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MeetingDAOException("SQL Error in Meeting insert: " + meeting);
        }
    }

    @Override
    public Meeting update(Meeting meeting) throws MeetingDAOException {
        String sql = "UPDATE MEETINGS SET MEETING_ROOM = ?, MEETING_DATE = ? WHERE ID = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, meeting.getMeetingRoom());
            ps.setDate(2, new java.sql.Date(meeting.getMeetingDate().getTime()));
            ps.setInt(3, meeting.getId());

            int n = ps.executeUpdate();
            if (n >= 1) {
                return meeting;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MeetingDAOException("SQL Error in Meeting update: " + meeting);
        }
    }

    @Override
    public void delete(int id) throws MeetingDAOException {
        String sql = "DELETE FROM MEETINGS WHERE ID = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MeetingDAOException("SQL Error in Meeting delete with id: " + id);
        }
    }

    @Override
    public List<Meeting> getByMeetingRoom(String meetingRoom) throws MeetingDAOException {
        String sql = "SELECT * FROM MEETINGS WHERE MEETING_ROOM LIKE ?";
        List<Meeting> meetings = new ArrayList<>();

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs;

            ps.setString(1, meetingRoom + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Meeting meeting = new Meeting(
                        rs.getInt("ID"),
                        rs.getString("MEETING_ROOM"),
                        rs.getDate("MEETING_DATE")
                );
                meetings.add(meeting);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MeetingDAOException("SQL Error in Meeting getByMeetingRoom with meetingRoom: " + meetingRoom);
        }

        return meetings;
    }

    @Override
    public Meeting getById(int id) throws MeetingDAOException {
        String sql = "SELECT * FROM MEETINGS WHERE ID = ?";
        Meeting meeting = null;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                meeting = new Meeting(
                        rs.getInt("ID"),
                        rs.getString("MEETING_ROOM"),
                        rs.getDate("MEETING_DATE")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MeetingDAOException("SQL Error in Meeting getById with id: " + id);
        }

        return meeting;
    }
}
