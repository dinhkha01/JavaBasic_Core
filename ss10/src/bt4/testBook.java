package bt4;

public class testBook {
    public static void main(String[] args) {
        Book boo1 = new Book("hoa", "J97",23.4);
        System.out.println("Book 1: " + boo1.getTitle() + ", " + boo1.getAuthor() + ", " + boo1.getPrice());
        boo1.setPrice(-26.7);
    }
}
