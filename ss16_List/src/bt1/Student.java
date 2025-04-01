package bt1;

import java.util.Scanner;

public class Student {
    private String name;
    private int age;
    private boolean sex;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
    public void inputData(Scanner sc){
        name = sc.nextLine();
        age = Integer.parseInt(sc.nextLine());
        sex = Boolean.parseBoolean(sc.nextLine());
    }
    public void displayInfor(){
        System.out.println("Ten: "+name);
        System.out.println("Tuoi: "+age);
        System.out.println("Gioi tinh : "+(sex?"nam":"nu"));
    }
}
