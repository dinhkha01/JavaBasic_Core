package bt3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
             con = ConnectionDB.openConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(con != null){
            try{
                Statement stmt = con.createStatement();
                stmt.executeUpdate("Create table IF NOT EXISTS employees(" +
                        "id INT primary key AUTO_INCREMENT," +
                        "name varchar(255)," +
                        "address varchar(255) )");

                stmt.executeUpdate("INSERT INTO employees(name,address)" +
                        "values ('dang van lam','duc')," +
                                "('b','br')," +
                                "('c','vn')");
                ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
                while (rs.next()){
                    System.out.printf(
                            "id: %-5d | name: %-20s | address: %-20s \n",
                            rs.getInt("id"),rs.getString("name"),rs.getString("address")
                    );
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                ConnectionDB.closeConnection(con);
            }

        }
    }
}
