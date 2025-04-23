// ValidateCourse.java
package bttl.validate;

import bttl.entity.Courses;

public class ValidateCourse {
    public static boolean validate(Courses course) {
        if (course == null) return false;
        if (course.getName() == null || course.getName().trim().isEmpty()) return false;
        if (course.getDescription() == null || course.getDescription().trim().isEmpty()) return false;
        return true;
    }
}