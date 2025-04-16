package bt3;



import bt3.ConnectionDB;

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

            PreparedStatement createTable = con.prepareStatement("CREATE TABLE IF NOT EXISTS accounts(" +
                    "id int primary key AUTO_INCREMENT ," +
                    "name varchar(255)," +
                    "balance double )");
            createTable.executeUpdate();
            System.out.println("Da tao bang roi do nhe !!! ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void insertData(Connection con) throws SQLException {
        if (con == null){
            throw new RuntimeException("Không thể kết nối đến database");
        }
        try{
            con.setAutoCommit(false);
            try( PreparedStatement insert = con.prepareStatement("INSERT INTO accounts(name,balance) values (?,?)")){
                insert.setString(1, "kha");
                insert.setDouble(2,10);
                insert.executeUpdate();
                insert.setString(1, "bin");
                insert.setDouble(2,100);
                insert.executeUpdate();
                con.commit();
                System.out.println("da them");
            }
            try(PreparedStatement withdraw = con.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id= ?");
                PreparedStatement deposit = con.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id= ?") ){
                    withdraw.setDouble(1,20);
                    withdraw.setInt(2,1);
                    con.commit();
                System.out.println("da thuc hien tru tien");

            } catch (SQLException e){
                con.rollback();
                System.out.println("Loi da rollback");
                e.printStackTrace();

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
