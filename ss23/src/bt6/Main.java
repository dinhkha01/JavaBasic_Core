package bt6;

public class Main {
    public static void main(String[] args) {
        // Tạo 3 luồng với các mức ưu tiên khác nhau
        Thread thread1 = new Thread(new Task(), "Thread 1 (MIN_PRIORITY)");
        Thread thread2 = new Thread(new Task(), "Thread 2 (NORM_PRIORITY)");
        Thread thread3 = new Thread(new Task(), "Thread 3 (MAX_PRIORITY)");

        // Thiết lập mức ưu tiên
        thread1.setPriority(Thread.MIN_PRIORITY);    // Ưu tiên thấp nhất (1)
        thread2.setPriority(Thread.NORM_PRIORITY);   // Ưu tiên trung bình (5)
        thread3.setPriority(Thread.MAX_PRIORITY);    // Ưu tiên cao nhất (10)

        System.out.println("Bắt đầu các luồng:");
        System.out.println(thread1.getName() + " - priority: " + thread1.getPriority());
        System.out.println(thread2.getName() + " - priority: " + thread2.getPriority());
        System.out.println(thread3.getName() + " - priority: " + thread3.getPriority());

        // Khởi chạy các luồng
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
