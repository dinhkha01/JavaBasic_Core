package bt4;

import java.time.LocalDate;
import java.util.List;

public class Person {
    private String name;
    private LocalDate date;

    public Person(String name,LocalDate date) {
        this.date = date;
        this.name = name;
    }
    public int getAge(){
        LocalDate currenDate = LocalDate.now();
        return currenDate.getYear() - date.getYear();
    }
    public void showInfo(){
        System.out.println("Name: " + name);
        System.out.println("Date of birth: " + date);
        System.out.println("Age: " + getAge());

    }

    public static void main(String[] args) {
        List<Person> people = List.of(

                new Person("Quý", LocalDate.of(2000, 3, 25)),

                new Person("Lan", LocalDate.of(1998, 7, 10)),

                new Person("Minh", LocalDate.of(2005, 12, 1))

        );
        people.forEach(Person::showInfo);
    }
}
