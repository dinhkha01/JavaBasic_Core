// ICourse.java
package bttl.business.dao.Course;

import bttl.business.IGenericDao;
import bttl.entity.Courses;

public interface ICourse extends IGenericDao<Courses, Integer> {
    boolean isNameUnique(String name);
}