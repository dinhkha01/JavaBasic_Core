package bt5;

 class Electronics extends Product{
    private String h;

    public Electronics(int id, String name,String h) {
        super(id,name);
        this.h = h;
    }
     @Override
     public void display() {
         System.out.println("ID: " + id);
         System.out.println("Tên sản phẩm: " + name);
         System.out.println("h: " + h);
         System.out.println("--------------------------");
     }
}
