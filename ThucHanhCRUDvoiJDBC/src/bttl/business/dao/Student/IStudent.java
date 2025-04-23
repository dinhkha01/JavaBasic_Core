// IStudent.java
package bttl.business.dao.Student;

import bttl.business.IGenericDao;
import bttl.entity.Students;

import java.util.List;

public interface IStudent extends IGenericDao<Students, String> {
    List<Students> searchByName(String name);
    boolean isEmailUnique(String email);
    boolean isPhoneUnique(String phone);
}