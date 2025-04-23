// ValidateStudent.java (new file)
package bttl.validate;

import bttl.entity.Students;
import java.util.regex.Pattern;

public class ValidateStudent {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PHONE_REGEX = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";

    public static boolean validate(Students student) {
        if (student == null) return false;
        if (student.getId() == null || student.getId().trim().isEmpty()) return false;
        if (student.getName() == null || student.getName().trim().isEmpty()) return false;
        if (student.getEmail() == null || !Pattern.matches(EMAIL_REGEX, student.getEmail())) return false;
        if (student.getPhone() == null || !Pattern.matches(PHONE_REGEX, student.getPhone())) return false;
        if (student.getBod() == null) return false;
        return true;
    }
}