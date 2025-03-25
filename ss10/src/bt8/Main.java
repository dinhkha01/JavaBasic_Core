package bt8;


import bt7.Animals;

public class Main {
    public static void addAnimal(Animals[] animals, int[] count, Animals animal, int Max){
        if(count[0] < Max){
            animals[count[0]] = animal;
            count[0]++;
        } else {
            System.out.println("Array is full.");
        }
    }
    public static void displayAnimals(Animals[] animals, int[] count){
        for(int i = 0; i < count[0]; i++){
            animals[i].displayInfo();
            System.out.println("Sound: " + animals[i].makeSound());
            System.out.println("===================================");
        }
    }
    public static boolean check (Animals animal){
        if(animal.getAge() < 0 || animal.getName().isEmpty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        final int Max = 100;
        Animals[] animals = new Animals[Max];
        int[] count ={0};
        Animals dog1 = new Dog("TA", 5, "long xu");
        Animals cat1 = new Cat("Hao", 3, "hong");
        Animals dog2 = new Dog("Thuan", 5, "phoc soc");
        Animals cat2 = new Cat("Tran", 3, "vang");
        Dog testDog = new Dog("", -1, "Poodle");
        if(check(dog1)){
            addAnimal(animals, count, dog1, Max);
        }
        if(check(dog2)){
            addAnimal(animals, count, dog2, Max);
        }
        if(check(cat1)){
            addAnimal(animals, count, cat1, Max);
        }
        if(check(cat2)){
            addAnimal(animals, count, cat2, Max);
        }
        if(check(testDog)){
            addAnimal(animals, count, testDog, Max);
        }
        displayAnimals(animals, count);




    }
}
