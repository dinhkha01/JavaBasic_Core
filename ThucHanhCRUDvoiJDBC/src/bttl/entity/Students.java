// Students.java
package bttl.entity;

import java.util.Date;

public class Students {
    private String id;
    private String name;
    private String email;
    private String phone;
    private boolean sex;
    private Date bod;
    private int courseId;
    private String avatar;
    private boolean status;

    // Constructors, getters, setters
    public Students() {}

    public Students(String id, String name, String email, String phone, boolean sex,
                    Date bod, int courseId, String avatar, boolean status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.bod = bod;
        this.courseId = courseId;
        this.avatar = avatar;
        this.status = status;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public boolean isSex() { return sex; }
    public void setSex(boolean sex) { this.sex = sex; }
    public Date getBod() { return bod; }
    public void setBod(Date bod) { this.bod = bod; }
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }
    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}