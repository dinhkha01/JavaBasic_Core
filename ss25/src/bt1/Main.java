package bt1;

public class Main {
    public static void main(String[] args) {
        Account a = Account.getInstance();
        System.out.println(a.getName());
        System.out.println(a.getAge());
        System.out.println(a.getId());
        Account a1 = Account.getInstance();
        a1.setId(2);
        a1.setName("n");
        a1.setAge(20);
        System.out.println(a1.getName());
        System.out.println(a1.getAge());
        System.out.println(a1.getId());

    }
}
