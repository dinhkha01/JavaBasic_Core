package bt4.validate;

public class ValidateString {
    private int min;
    private int max;

    public ValidateString(int min, int max) {
        this.min = min;
        this.max = max;
    }
    public boolean isValid(String value){
        return value.length() > min && value.length() <= max;
    }
    public String errorMassage(){
        return "do dai nam trong khoang " + min + " -> "+ max + " ki tu";
    }
}
