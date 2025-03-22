package bt4;

public class Tv implements  Electric{

    @Override
    public void turnOn() {
        System.out.println("Mo TV...");
    }

    @Override
    public void turnOff() {
        System.out.println("Tat TV...");

    }
}
