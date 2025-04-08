package bt5;

class SharedData {
    private String message;
    private boolean messageReady = false;

    // Phương thức đồng bộ để gửi tin nhắn
    public synchronized void sendMessage(String msg) {
        // Nếu tin nhắn chưa được xử lý, đợi
        while (messageReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.message = msg;
        messageReady = true;
        System.out.println("Người gửi đã gửi tin nhắn: " + msg);
        notify(); // Thông báo cho người nhận
    }

    // Phương thức đồng bộ để nhận tin nhắn
    public synchronized void receiveMessage() {
        // Nếu chưa có tin nhắn, đợi
        while (!messageReady) {
            try {
                System.out.println("Người nhận đang chờ tin nhắn...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Người nhận đã nhận được tin nhắn: " + message);
        messageReady = false;
        notify(); // Thông báo cho người gửi có thể gửi tin mới
    }
}