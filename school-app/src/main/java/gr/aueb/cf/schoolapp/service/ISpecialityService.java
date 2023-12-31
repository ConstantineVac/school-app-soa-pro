package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.exceptions.SpecialityDAOException;
import gr.aueb.cf.schoolapp.dto.SpecialityInsertDTO;
import gr.aueb.cf.schoolapp.dto.SpecialityUpdateDTO;
import gr.aueb.cf.schoolapp.model.Speciality;
import gr.aueb.cf.schoolapp.service.exceptions.SpecialityNotFoundException;


import java.util.List;

public interface ISpecialityService {
    Speciality insertSpeciality(SpecialityInsertDTO dto) throws SpecialityDAOException;

    Speciality updateSpeciality(SpecialityUpdateDTO dto) throws SpecialityDAOException, SpecialityNotFoundException;

    void deleteSpeciality(int id) throws SpecialityDAOException, SpecialityNotFoundException;

    List<Speciality> getSpecialitiesByTitle(String speciality) throws SpecialityDAOException;

    Speciality getSpecialityById(int id) throws SpecialityDAOException, SpecialityNotFoundException;
}
