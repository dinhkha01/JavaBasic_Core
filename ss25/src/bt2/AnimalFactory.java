package bt2;

public class AnimalFactory {
    public static IAnimal hi (String type){
        if (type.equalsIgnoreCase("Cat")){
            return new Cat();
        } else if (type.equalsIgnoreCase("DOG")){
            return new Dog();
        }return null;
    }
}
