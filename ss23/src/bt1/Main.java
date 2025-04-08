package bt1;

public class Main extends Thread {
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+" dang chay");
    }

    public static void main(String[] args) {
        Main m1 = new Main();
        Main m2 = new Main();
        m1.start();
        m2.start();
    }
}
