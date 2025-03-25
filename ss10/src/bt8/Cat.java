package bt8;


import bt7.Animals;

public class Cat extends Animals {
    private String furColor;
    public Cat(String name, int age, String furColor) {
        super(name, age);
        this.furColor = furColor;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }
    @Override
    public String makeSound() {
       return "Mews";
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Fur Color: " + furColor);
    }
}
