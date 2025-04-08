package bt4;

public class Main {
    public static void main(String[] args) {
        // Tạo các thread
        MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");
        MyThread thread3 = new MyThread("Thread-3");

        // Bắt đầu Thread 1
        thread1.start();

        try {
            // Thread 2 và 3 đợi Thread 1 hoàn thành
            thread1.join();

            // Sau khi Thread 1 hoàn thành, bắt đầu Thread 2 và 3
            thread2.start();
            thread3.start();

            // Đợi Thread 2 và 3 hoàn thành (nếu cần)
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tất cả các thread đã hoàn thành!");
    }
}
