package bt1.validate;

public class ValidateString {
    private int minLength;
    private int maxLength;

    public ValidateString(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }
    public boolean isValid(String value){
        return value.length()> minLength && value.length()< maxLength;
    }
    public String errorMassage(){
        return "Độ dài chuỗi phải trong khoảng " + minLength + "->" + maxLength + "Kí tự";
    }
}
