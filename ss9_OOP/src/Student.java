public class Student {
    private int id;
    private String name;
    private int age;
    private  boolean sex;



    public Student(int id, String name, int age, boolean sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public void displayInfo(){
        System.out.println("id: " + id + " | name: " + name + " | tuoi: "+ age + " | gioi tinh: "+ (sex?"Nam":"nu"));
    }
}
