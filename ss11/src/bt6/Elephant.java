package bt6;

public class Elephant extends Animal {
    public Elephant(String name, int age) {
        super(name, age);
    }
    @Override
    void sound() {
        System.out.println(getName()+ " keu eeeeeeeee");
    }

    @Override
    void move() {
        System.out.println(getName() + " is running");

    }
}
