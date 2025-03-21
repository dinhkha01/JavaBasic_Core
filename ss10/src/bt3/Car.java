package bt3;

import java.time.Year;
import java.util.Date;

public class Car {
    private String make;
    private String model;
    private int year;
    public Car(String make,String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if(year <= currentYear){
            this.year = year;
        }else {
            System.out.print("Nam san xuat khong hop le !!!");
        }
    }
}
