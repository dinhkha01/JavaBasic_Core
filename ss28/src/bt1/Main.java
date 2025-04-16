package bt1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
     try{
         con = ConnectionDB.openConnection();
         createTable(con);
         insertData(con);
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }finally {
         ConnectionDB.closeConnection(con);
     }
    }
    public static void createTable(Connection con){
        if(con == null) {
            throw new RuntimeException("Không thể kết nối đến database");
        };
        try{
//            String sql = "CREATE TABLE IF NOT EXISTS users(" +
//                    "id int AUTO_INCREMENT primary key," +
//                    "name vachar(255))";
            PreparedStatement createTable = con.prepareStatement("CREATE TABLE IF NOT EXISTS users(" +
                    "id int primary key AUTO_INCREMENT," +
                    "name varchar(255))");
            createTable.executeUpdate();
            System.out.println("Da tao bang roi do nhe !!! ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void insertData(Connection con){
        if (con == null){
            throw new RuntimeException("Không thể kết nối đến database");
        }
        try{
            con.setAutoCommit(false);
            PreparedStatement insert = con.prepareStatement("INSERT INTO users(name) values (?)");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            insert.setString(1,name);
            insert.executeUpdate();
            con.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
