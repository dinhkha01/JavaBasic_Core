package bt3;

public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng SharedResource dùng chung
        SharedResource sharedResource = new SharedResource();

        // Tạo và chạy 2 thread cùng sử dụng sharedResource
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 bắt đầu in:");
            sharedResource.printAlphabet();
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 bắt đầu in:");
            sharedResource.printAlphabet();
        });

        // Khởi chạy các thread
        thread1.start();
        thread2.start();
    }
}
