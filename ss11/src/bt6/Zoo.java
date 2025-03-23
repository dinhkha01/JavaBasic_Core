package bt6;

public class Zoo {
    int max= 100;
    Animal[] animals= new Animal[max];
    int count;
    public void add(Animal animal){
        if(count<max){
            animals[count]= animal;
            count++;
        }else {
            System.out.println("Zoo is full");
        }
    }
    public void makeSound(){
        for(int i=0 ; i<count ; i++){
            animals[i].sound();

        }
    }
    public void moveAll(){
        for(int i=0 ; i<count ; i++){
            animals[i].move();
        }
    }
}
