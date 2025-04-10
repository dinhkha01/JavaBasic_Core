package bt2;

public class Main {
    public static void main(String[] args) {
        IAnimal a1 = AnimalFactory.hi("cat");
        a1.speak();
        IAnimal a2 = AnimalFactory.hi("dog");
        a2.speak();

    }
}
