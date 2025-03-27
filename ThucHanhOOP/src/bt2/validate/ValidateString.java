package bt2.validate;

public class ValidateString {
    private int minLength;
    private int maxLength;

    public ValidateString(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public boolean idVal(String value){
        return value.length() > minLength && value.length() < maxLength;
    }
    public String errorMassage(){
        return "Ten san pham phai trong khoang " + minLength + "->"+ maxLength + " ki tu ";
    }

}
