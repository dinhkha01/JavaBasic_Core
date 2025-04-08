package bt5;

public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        // Thread người gửi
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(1000); // Giả lập thời gian chuẩn bị tin nhắn
                sharedData.sendMessage("Xin chào! Bạn khỏe không?");

                Thread.sleep(2000); // Giả lập thời gian chuẩn bị tin nhắn tiếp
                sharedData.sendMessage("Hôm nay bạn làm gì?");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Thread người nhận
        Thread reader = new Thread(() -> {
            sharedData.receiveMessage();

            try {
                Thread.sleep(1500); // Giả lập thời gian xử lý tin nhắn
                sharedData.receiveMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Bắt đầu các thread
        reader.start();
        writer.start();
    }
}
