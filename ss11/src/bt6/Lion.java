package bt6;

public class Lion extends Animal {
    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    void sound() {
     System.out.println(getName()+" keu gugugyuuuu");
    }

    @Override
    void move() {
        System.out.println(getName()+" is running");
    }
}
