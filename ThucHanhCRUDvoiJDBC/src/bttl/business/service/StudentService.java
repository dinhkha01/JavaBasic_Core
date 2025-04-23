package bttl.business.service;

import bttl.business.dao.Student.IStudent;
import bttl.entity.Students;
import java.util.List;

public class StudentService {
    private IStudent studentDao;

    public StudentService(IStudent studentDao) {
        this.studentDao = studentDao;
    }

    public List<Students> getAllStudents() {
        return studentDao.findAll();
    }

    public Students getStudentById(String id) {
        return studentDao.findById(id);
    }

    public boolean addStudent(Students student) {
        if (studentDao.isEmailUnique(student.getEmail()) &&
                studentDao.isPhoneUnique(student.getPhone())) {
            studentDao.save(student);
            return true;
        }
        return false;
    }

    public boolean updateStudent(Students student) {
        Students existing = studentDao.findById(student.getId());
        if (existing != null) {
            boolean emailOK = existing.getEmail().equals(student.getEmail()) ||
                    studentDao.isEmailUnique(student.getEmail());
            boolean phoneOK = existing.getPhone().equals(student.getPhone()) ||
                    studentDao.isPhoneUnique(student.getPhone());

            if (emailOK && phoneOK) {
                studentDao.save(student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(String id) {
        return studentDao.deleteById(id);
    }

    public List<Students> searchStudentsByName(String name) {
        return studentDao.searchByName(name);
    }
}