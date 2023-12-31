package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.service.util.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TeacherDAOImpl implements ITeacherDAO {
    @Override
    public Teacher insert(Teacher teacher) throws TeacherDAOException {
        String sql = "INSERT INTO TEACHERS(FIRSTNAME, LASTNAME, SSN, USER_ID, SPECIALITY_ID) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            String firstname = teacher.getFirstname();
            String lastname = teacher.getLastname();
            Integer ssn = teacher.getSsn();
            Integer userId = teacher.getUserId();
            Integer specialityId = teacher.getSpecialityId();

            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setInt(3, ssn);
            ps.setInt(4, userId);
            ps.setInt(5, specialityId);

            int n = ps.executeUpdate();
            if (n >= 1) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        teacher.setId(generatedKeys.getInt(1));
                    }
                }
                JOptionPane.showMessageDialog(null, n + " row(s) affected", "Successful Insert", JOptionPane.PLAIN_MESSAGE);
                return teacher;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TeacherDAOException("SQL Error in Teacher insert" + teacher);
        }
    }

    @Override
    public Teacher update(Teacher teacher) throws TeacherDAOException {
        String sql = "UPDATE TEACHERS SET FIRSTNAME = ?, LASTNAME = ?, SSN = ?, USER_ID = ?, SPECIALITY_ID = ? WHERE ID = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, teacher.getFirstname());
            ps.setString(2, teacher.getLastname());
            ps.setInt(3, teacher.getSsn());
            ps.setInt(4, teacher.getUserId());
            ps.setInt(5, teacher.getSpecialityId());
            ps.setInt(6, teacher.getId());

            int n = ps.executeUpdate();
            if (n >= 1) {
                JOptionPane.showMessageDialog(null, n + " row(s) affected", "Successful Update", JOptionPane.PLAIN_MESSAGE);
                return teacher;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TeacherDAOException("SQL Error in Teacher Update" + teacher);
        }
    }

    @Override
    public void delete(int id) throws TeacherDAOException {
        String sql = "DELETE FROM TEACHERS WHERE ID = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TeacherDAOException("SQL Error in Teacher with id: " + id);
        }
    }

    @Override
    public List<Teacher> getByLastname(String lastname) throws TeacherDAOException {
        String sql = "SELECT * FROM TEACHERS WHERE LASTNAME LIKE ?";
        List<Teacher> teachers = new ArrayList<>();

        // ResultSet rs = null;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs;

            ps.setString(1, lastname + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Teacher teacher = new Teacher(
                        rs.getInt("ID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getInt("SSN"),
                        rs.getInt("USER_ID"),
                        rs.getInt("SPECIALITY_ID")
                );
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TeacherDAOException("SQL Error in Teacher Delete with lastname" + lastname);
        }
//        finally {
//            try {
//                if (rs != null) rs.close();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
//        }
        return teachers;
    }

    @Override
    public Teacher getById(int id) throws TeacherDAOException {
        String sql = "SELECT * FROM TEACHERS WHERE ID = ?";
        Teacher teacher = null;
        ResultSet rs = null;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                teacher = new Teacher(
                        rs.getInt("ID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getInt("SSN"),
                        rs.getInt("USER_ID"),
                        rs.getInt("SPECIALITY_ID")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TeacherDAOException("SQL Error in Teacher Get with id: " + id);
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return teacher;
    }
}
