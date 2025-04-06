package bt3;

import java.util.List;
import java.util.Optional;

public class User {
    private String name;
    private Optional<String> phone;

    public User(String name, Optional<String> phone) {
        this.name = name;
        this.phone = phone;
    }
    public void showInfo(){
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone.orElse( "khong co"));
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        List<User> users = List.of(

                new User("Quý", Optional.of("0987654321")),

                new User("Lan", Optional.empty()),

                new User("Minh", Optional.of("0933222111")),

                new User("Huyền", Optional.empty())

        );
        users.forEach(User::showInfo);
    }
}
