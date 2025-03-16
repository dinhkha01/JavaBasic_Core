package bt1;

public class main {
    public static void main(String[] args) {
        int[] arr ={1, 2, 9, 4, 5};
        int temp = arr[0];
        for(int i=0; i< arr.length;i++){
            if(arr[i]> temp){
                temp = arr[i];
            }
        }
        System.out.printf("phan tu lon nhat trong mang la %d",temp);


    }
}
