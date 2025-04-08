package bt4;

import java.io.ObjectOutputStream;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Student
        Student student = new Student("Nguyen Van A", 20, 8.5);

        // Ghi đối tượng vào file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"))) {
            oos.writeObject(student);
            System.out.println("Đã ghi đối tượng vào file student.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đọc đối tượng từ file
        Student readStudent = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"))) {
            readStudent = (Student) ois.readObject();
            System.out.println("Đã đọc đối tượng từ file student.dat");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Hiển thị thông tin đối tượng đọc được
        if (readStudent != null) {
            System.out.println("Thông tin sinh viên:");
            System.out.println(readStudent);
        }
    }
}
