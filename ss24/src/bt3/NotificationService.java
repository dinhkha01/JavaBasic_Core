package bt3;

class NotificationService {
    private Notification notification;

    // Constructor injection
    public NotificationService(Notification notification) {
        this.notification = notification;
    }

    public void sendNotification(String message) {
        notification.send(message);
    }

    // Setter injection (cách khác để inject dependency)
    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
