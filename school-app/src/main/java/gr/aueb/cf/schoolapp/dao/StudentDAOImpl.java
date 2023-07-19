package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.dao.exceptions.StudentDAOException;
import gr.aueb.cf.schoolapp.model.Student;
import gr.aueb.cf.schoolapp.service.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {
    @Override
    public Student insert(Student student) throws StudentDAOException {
        String sql = "INSERT INTO STUDENTS(FIRSTNAME, LASTNAME, GENDER, BIRTHDATE) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, student.getFirstname());
            ps.setString(2, student.getLastname());
            ps.setString(3, student.getGender());
            ps.setDate(4, new java.sql.Date(student.getBirthdate().getTime()));

            int n = ps.executeUpdate();
            if (n >= 1) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        student.setId(generatedKeys.getInt(1));
                    }
                }
                return student;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("SQL Error in Student insert" + student);
        }
    }

    @Override
    public Student update(Student student) throws StudentDAOException {
        String sql = "UPDATE STUDENTS SET FIRSTNAME = ?, LASTNAME = ?, GENDER = ?, BIRTHDATE = ? WHERE ID = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, student.getFirstname());
            ps.setString(2, student.getLastname());
            ps.setString(3, student.getGender());
            ps.setDate(4, new java.sql.Date(student.getBirthdate().getTime()));
            ps.setInt(5, student.getId());

            int n = ps.executeUpdate();
            if (n >= 1) {
                return student;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("SQL Error in Student Update" + student);
        }
    }

    @Override
    public void delete(int id) throws StudentDAOException {
        String sql = "DELETE FROM STUDENTS WHERE ID = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("SQL Error in Student with id: " + id);
        }
    }

    @Override
    public List<Student> getByLastname(String lastname) throws StudentDAOException {
        String sql = "SELECT * FROM STUDENTS WHERE LASTNAME = ?";

        List<Student> students = new ArrayList<>();
        ResultSet rs = null;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, lastname);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("ID"));
                student.setFirstname(rs.getString("FIRSTNAME"));
                student.setLastname(rs.getString("LASTNAME"));
                student.setGender(rs.getString("GENDER"));
                student.setBirthdate(rs.getDate("BIRTHDATE"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("SQL Error in Student Get with lastname" + lastname);
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return students;
    }

    @Override
    public Student getById(int id) throws StudentDAOException {
        String sql = "SELECT * FROM STUDENTS WHERE ID = ?";
        Student student = null;
        ResultSet rs = null;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("ID"));
                student.setFirstname(rs.getString("FIRSTNAME"));
                student.setLastname(rs.getString("LASTNAME"));
                student.setGender(rs.getString("GENDER"));
                student.setBirthdate(rs.getDate("BIRTHDATE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("SQL Error in Student Get with id: " + id);
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return student;
    }
}
