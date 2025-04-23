// CourseService.java
package bttl.business.service;

import bttl.business.dao.Course.ICourse;
import bttl.entity.Courses;
import java.util.List;

public class CourseService {
    private ICourse courseDao;

    public CourseService(ICourse courseDao) {
        this.courseDao = courseDao;
    }

    public List<Courses> getAllCourses() {
        return courseDao.findAll();
    }

    public Courses getCourseById(int id) {
        return courseDao.findById(id);
    }

    public boolean addCourse(Courses course) {
        if (courseDao.isNameUnique(course.getName())) {
            courseDao.save(course);
            return true;
        }
        return false;
    }

    public boolean updateCourse(Courses course) {
        Courses existing = courseDao.findById(course.getId());
        if (existing != null &&
                (existing.getName().equals(course.getName()) || courseDao.isNameUnique(course.getName()))) {
            courseDao.save(course);
            return true;
        }
        return false;
    }

    public boolean deleteCourse(int id) {
        return courseDao.deleteById(id);
    }
}