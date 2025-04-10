package bt1;

public class Account {
   private int id;
    private String name;
    private int age;
    private static Account instance;

    public Account() {
        id=1;
        name="a";
        age=10;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void setInstance(Account instance) {
        Account.instance = instance;
    }

    public static Account getInstance(){
        if(instance == null){
            instance = new Account();
        }
        return instance;
    }
}
