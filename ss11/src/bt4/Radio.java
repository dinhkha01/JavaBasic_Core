package bt4;

public class Radio implements Electric{
    @Override
    public void turnOn() {
        System.out.println("Mo Radio");

    }

    @Override
    public void turnOff() {
        System.out.println("Tat Radio");

    }
}
