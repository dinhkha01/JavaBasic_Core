package bt5;

public class Clothing extends Product{
    private String abc;
    public Clothing(int id, String name, String abc) {
        super(id, name);
        this.abc = abc;
    }
    @Override
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Tên sản phẩm: " + name);
        System.out.println("Hãng: " + abc);
        System.out.println("--------------------------");
    }
}
