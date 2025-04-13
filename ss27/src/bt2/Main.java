package bt2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try{
            con= ConnectionDB.openConnection();
            createAndInsertTable(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(con);
        }
    }
    public static void createAndInsertTable(Connection con){
        if(con == null){
            throw new RuntimeException("Không thể kết nối đến database");
        }
        try{
            String sqlCreate ="CREATE table IF NOT EXISTS students(" +
                    "id int primary key AUTO_INCREMENT," +
                    "name varchar(255)," +
                    "age int," +
                    "major varchar(255)) ";
            try( PreparedStatement create = con.prepareStatement(sqlCreate)){
                create.executeUpdate();
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("nhap ten: ");
            String name = sc.nextLine();
            System.out.println("nhap tuoi: ");
            int age = Integer.parseInt(sc.nextLine());
            System.out.println("nhap major : ");
            String major  = sc.nextLine();

            try(PreparedStatement insert = con.prepareStatement("INSERT INTO students(name,age,major) values (?,?,?)")){
                insert.setString(1,name);
                insert.setInt(2,age);
                insert.setString(3,major);
                insert.executeUpdate();
            }
            try(PreparedStatement show = con.prepareStatement("SELECT * FROM students")){
                ResultSet rs = show. executeQuery();
                while (rs.next()){
                    System.out.printf("id: %-3d | name: %-10s | age: %-5d | major: %-10s \n",rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("major"));

                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
