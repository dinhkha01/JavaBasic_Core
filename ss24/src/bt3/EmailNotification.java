package bt3;
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Gửi email thông báo: " + message);
    }
}