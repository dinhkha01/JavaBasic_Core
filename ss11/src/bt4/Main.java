package bt4;

public class Main {
    public static void main(String[] args) {
      Electric[] devices =  new Electric[2];
      devices[0] = new Tv();
      devices[1] = new Radio();
      for (Electric may : devices){
          may.turnOn();
          may.turnOff();
          System.out.println();
      }
    }
}
