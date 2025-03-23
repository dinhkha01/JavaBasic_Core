package bt7;

public class main {


    // Thêm sinh viên vào danh sách
    public static void addStudent(Student student, Student[] students ,  int[] countRef, int MAX_STUDENTS) {
        if (countRef[0] < MAX_STUDENTS) {
            students[countRef[0]] = student;
            countRef[0]++;
            System.out.println("Đã thêm sinh viên: " + student.getName());
        } else {
            System.out.println("Danh sách sinh viên đã đầy!");
        }
    }

    // Hiển thị thông tin của tất cả sinh viên
    public static void displayAllStudents(Student[] students, int count) {
        if (count == 0) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }

        for (int i = 0; i < count; i++) {
            students[i].getDetails();
        }
    }
    // Kiểm tra tính hợp lệ của dữ liệu
    public static boolean validateStudent(Student student) {
        // Kiểm tra GPA
        if (student.getGpa() < 0) {
            return false;
        }

        // Kiểm tra tên và ID không được rỗng
        if (student.getName() == null || student.getName().trim().isEmpty() ||
                student.getId() == null || student.getId().trim().isEmpty()) {
            return false;
        }

        // Kiểm tra thêm cho sinh viên tốt nghiệp
        if (student instanceof GraduateStudent) {
            GraduateStudent gradStudent = (GraduateStudent) student;
            if (gradStudent.getResearchTopic() == null || gradStudent.getResearchTopic().trim().isEmpty() ||
                    gradStudent.getSupervisorName() == null || gradStudent.getSupervisorName().trim().isEmpty()) {
                return false;
            }
        }

        return true;
    }

    // Phương thức chính để kiểm thử
    public static void main(String[] args) {

         final int MAX_STUDENTS = 100;
        Student[] students = new Student[MAX_STUDENTS];

         int[] count = {0};

        // Tạo sinh viên thường
        Student student1 = new Student("Nguyễn Văn A", "SV001", 3.5);
        Student student2 = new Student("Trần Thị B", "SV002", 3.8);

        // Tạo sinh viên tốt nghiệp
        GraduateStudent gradStudent1 = new GraduateStudent("Lê Văn C", "GD001", 3.7,
                "Trí tuệ nhân tạo", "PGS. Nguyễn Văn X");
        GraduateStudent gradStudent2 = new GraduateStudent("Phạm Thị D", "GD002", 3.9,
                "Khoa học dữ liệu", "TS. Trần Văn Y");

        // Kiểm tra tính hợp lệ trước khi thêm
        if (validateStudent(student1)) {
            addStudent(student1, students,count,MAX_STUDENTS);
        }
        if (validateStudent(student2)){
            addStudent(student2,students,count,MAX_STUDENTS);
        }
        if (validateStudent(gradStudent1)){
            addStudent(gradStudent1,students,count,MAX_STUDENTS);
        }
        if (validateStudent(gradStudent2)){
            addStudent(gradStudent2,students,count,MAX_STUDENTS);
        }

        // Hiển thị thông tin của tất cả sinh viên
        System.out.println("Danh sách sinh viên:");
        displayAllStudents(students,count[0]);
    }
}
