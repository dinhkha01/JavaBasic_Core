package bt3.validate;

import java.util.Scanner;
import static bt3.business.EmployeeManager.*;

public class ValidateEmployee {

    public static String validateId(Scanner sc){
        while(true){
            String id = InputMethod.inputString(sc,"Nhập ID của nhân viên(gồm 4 kí tự và bắt đâu bằng chữ E)","Id không được để trống");
            ValidateString val = new ValidateString(0,0);
            if(val.isVal(id,4,"E")){
                if(isIdEmployeeUnique(id)) return id;
                System.err.println("Id da duoc tồn tại");
                continue;
            }
            System.err.println(val.errorMassage(4,"E"));
        }
    }
    public static boolean isIdEmployeeUnique(String id){
        for(int i =0; i < size ; i++){
            if(employees[i].getId().equals(id)){
                return false;
            }
        }
        return true;
    }
    public static String validateName(Scanner sc ){
        while(true){
            String name = InputMethod.inputString(sc,"Nhập tên nhân viên từ 6 -> 255 kí tự", " Tên nhân viên không dc để trống");
            ValidateString val = new ValidateString(6,255);
            if(val.isVal(name)) return name;
            System.err.println(val.errorMassage());
        }
    }
    public static int validateYear(Scanner sc ){
        System.out.println("Nhập năm sinh > 1980");
        while(true){
           int year = InputMethod.inputInt(sc, "Năm phải là số nguyên");
           if(year >= 1980 ) return year;
           System.err.println("Năm phải lớn hơn hoặc bằng 1980");
        }
    }
    public static float validateRate(Scanner sc){
        System.out.println("Nhập hệ số lương phải lớn hơn 0");
        while(true){
            float rate = InputMethod.inputFloat(sc,"hệ số lương nhân viên phải là số");
            if(rate > 0) return rate;
            System.err.println("Hệ số lương phải lớn hơn 0");
        }
    };
    public static float validateCommission(Scanner sc){
        System.out.println(" Hoa hồng của nhân viên hàng tháng >= 0");
        while(true){
            float commission  = InputMethod.inputFloat(sc,"Hoa hồng của nhân viên hàng tháng phải là số");
            if(commission  >= 0) return commission ;
            System.err.println(" Hoa hồng của nhân viên hàng tháng >= 0");
        }
    };
    public static boolean validateStatus(Scanner sc){
        return InputMethod.inputBoolean(sc,"Nhập trạng thái nhân viên ( true / đang làm việc, false / nghỉ việc )","Trạng thái không hợp lệ !!!");
    };



}
