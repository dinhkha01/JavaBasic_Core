package bt4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;
// DELIMITER //
//BEGIN
//        SELECT id, name, salary
//FROM employees
//WHERE id = emp_id;
//END //

public class Main {
    public static void main(String[] args) {
        Connection con= null;

        try{
                con = ConnectionDB.openConnection();
                System.out.println("nhap id muon tim:");
                Scanner sc = new Scanner(System.in);
                int id = sc.nextInt();
                CallableStatement call = con.prepareCall("{call getEmployeeDetails(?)  }");
                call.setInt(1,id);
                ResultSet rs = call.executeQuery();
                if(rs.next()) {
                    System.out.println("nguoi can tim la");
                    System.out.printf("ID: %-3d | name: %-10s | salary: %-,5f", rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                ConnectionDB.closeConnection(con);
            }
        }

}
