package bt4;

class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (name.equals("Thread-1")) {
            // Thread 1 in số từ 1 đến 5, mỗi số cách nhau 1 giây
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(name + ": " + i);
                    Thread.sleep(1000); // Dừng 1 giây
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            // Thread 2 và 3 chỉ in thông báo đơn giản
            System.out.println(name + " bắt đầu làm việc...");
        }
    }
}