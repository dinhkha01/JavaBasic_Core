package bt3.validate;

public class ValidateString {
    private int min;
    private int max;

    public ValidateString(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean isVal(String value){
        return value.length() > min && value.length() < max;
    }
    public String errorMassage(){
        return "do dai chuoi phai tu " + min + " -> "+ max + "ki tu ";
    }
    public boolean isVal(String value, int intCharacter, String startCharacter){
        return value.length() == intCharacter && value.startsWith(startCharacter);
    }
    public String errorMassage(int intCharacter, String startCharacter){
        return "ID phải gồm " + intCharacter +  " kí tự và bắt đầu bằng chữ  " + startCharacter  ;
    }
}
