package bt3;

public class Main {
    public static void main(String[] args) {
        // Tạo các dịch vụ thông báo
        Notification emailNoti = new EmailNotification();
        Notification smsNoti = new SMSNotification();

        // Sử dụng constructor injection
        NotificationService emailService = new NotificationService(emailNoti);
        NotificationService smsService = new NotificationService(smsNoti);

        // Gửi thông báo
        emailService.sendNotification("Xin chào qua email!");
        smsService.sendNotification("Xin chào qua SMS!");

        // Sử dụng setter injection để thay đổi loại thông báo
        NotificationService flexibleService = new NotificationService(emailNoti);
        flexibleService.sendNotification("Thông báo đầu tiên qua email");

        // Thay đổi sang SMS
        flexibleService.setNotification(smsNoti);
        flexibleService.sendNotification("Thông báo thứ hai qua SMS");
    }
}