package bt2;

public class main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello, Java World!");
        System.out.println("gia tri ban dau la: "+sb);
        sb.delete(5,11);
        System.out.println("sau khi xoa: "+sb);
        sb.replace(6,12,"cc");
        System.out.println("sau khi thay the: "+sb);

    }
}
