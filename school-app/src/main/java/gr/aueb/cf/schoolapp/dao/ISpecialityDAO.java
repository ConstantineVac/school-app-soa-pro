package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.dao.exceptions.SpecialityDAOException;
import gr.aueb.cf.schoolapp.model.Speciality;

import java.util.List;


public interface ISpecialityDAO {
    List<Speciality> getBySpeciality(String specialityTitle) throws SpecialityDAOException;
    Speciality getById(int id) throws SpecialityDAOException;
    Speciality insert(Speciality speciality) throws SpecialityDAOException;
    Speciality update(Speciality speciality) throws SpecialityDAOException;
    void delete(int id) throws SpecialityDAOException;
}
