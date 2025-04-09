package bt3;

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Gửi SMS thông báo: " + message);
    }
}
