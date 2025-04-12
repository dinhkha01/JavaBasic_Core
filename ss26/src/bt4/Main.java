package bt4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection con= null;
        try {
             con = ConnectionDB.openConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(con!=null){
            try{
                Statement stmt = con.createStatement();
                stmt.executeUpdate("Create table IF NOT EXISTS users(" +
                        "id INT primary key AUTO_INCREMENT," +
                        "name varchar(255)," +
                        "address varchar(255) )");
                stmt.executeUpdate("INSERT INTO users(name,address)" +
                        "values ('dang van lam','duc')," +
                        "('b','br')," +
                        "('c','vn')");
                System.out.println("du lieu ban dau");
                ResultSet rs1 = stmt.executeQuery("SELECT * FROM users");
                while (rs1.next()){
                    System.out.printf(
                            "id: %-5d | name: %-20s | address: %-20s \n",
                            rs1.getInt("id"),rs1.getString("name"),rs1.getString("address")
                    );
                }
                stmt.executeUpdate("UPDATE users SET name='haahahahahah' WHERE id=2");
                System.out.println(" du lieu da cap nhat");
                ResultSet rs2 = stmt.executeQuery("SELECT * FROM users");
                while (rs2.next()){
                    System.out.printf(
                            "id: %-5d | name: %-20s | address: %-20s \n",
                            rs2.getInt("id"),rs2.getString("name"),rs2.getString("address")
                    );
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {

                ConnectionDB.closeConnection(con);
            }
        }
    }
}
