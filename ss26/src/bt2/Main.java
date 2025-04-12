package bt2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
             con = ConnectDB.openConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(con!= null){
            try{
                Statement stmt = con.createStatement();
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS customers(" +
                        "id INT PRIMARY KEY AUTO_INCREMENT," +
                        "name varchar(277)," +
                        "age INT)");

                stmt.executeUpdate("INSERT INTO customers(name,age)" +
                        "values ('a',1)," +
                                "('b',2)," +
                                "('c',3)," +
                                "('d',4)," +
                                "('d',5)");
                ResultSet rs = stmt.executeQuery("SELECT * FROM customers ");
                while (rs.next()){
                    System.out.printf(
                            "[ID:%-5d | NAME: %-20s | AGE: %-5d]\n",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("age")
                    );
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            finally {
                ConnectDB.closeConnection(con);
            }
        }
    }
}
