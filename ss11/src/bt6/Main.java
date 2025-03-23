package bt6;

public class Main {
    public static void main(String[] args) {
        Lion linon = new Lion("TA",20);
        Elephant elephant = new Elephant("Tran",20);

        Zoo zoo = new Zoo();
        zoo.add(linon);
        zoo.add(elephant);

        zoo.makeSound();
        zoo.moveAll();




    }
}
