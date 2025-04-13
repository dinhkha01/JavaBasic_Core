package bt3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try{
            con= ConnectionDB.openConnection();
            createAndInsertTable(con);
            updateById(con);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(con);
        }
    }
    public static void createAndInsertTable(Connection con){
        if(con == null){
            throw new RuntimeException("Không thể kết nối đến database");
        }
        try{
            String sql ="CREATE TABLE IF NOT EXISTS employees(" +
                    "id int primary key AUTO_INCREMENT," +
                    "name varchar(255)," +
                    "salary double precision)";
            try(PreparedStatement createTable = con.prepareStatement(sql)){
                createTable.executeUpdate();
            }
            try(PreparedStatement insert = con.prepareStatement("INSERT INTO employees(name,salary) values (?,?)")){
                insert.setString(1, "a");
                insert.setDouble(2, 10000);
                insert.addBatch();

                insert.setString(1, "b");
                insert.setDouble(2, 20000);
                insert.addBatch();

                insert.setString(1, "c");
                insert.setDouble(2, 30000);
                insert.addBatch();

                int[] rows = insert.executeBatch();
                System.out.println("Đã thêm " + rows.length + " dòng");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void updateById(Connection con){
        if( con == null){
            throw new RuntimeException("khong the ket noi database");
        }
        try{
            try(PreparedStatement update = con.prepareStatement("UPDATE employees SET salary = ? WHERE id = ?");
                PreparedStatement show = con.prepareStatement("SELECT * FROM employees WHERE id = ?")
            ){
                Scanner sc = new Scanner(System.in);
                System.out.println("nhap id muon doi luong: ");
                int id = sc.nextInt();
                System.out.println("nhap luong muon thay doi: ");
                double salary = sc.nextDouble();
                update.setDouble(1,salary);
                update.setInt(2,id);
                update.executeUpdate();
                show.setInt(1,id);
                ResultSet rs = show.executeQuery();
                while (rs.next()){
                    System.out.println("thong tin moi cap nhat");
                    System.out.printf("id: %-3d| name: %-10s | salary: %-,5f ", rs.getInt("id"), rs.getString("name"),rs.getDouble("salary"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
