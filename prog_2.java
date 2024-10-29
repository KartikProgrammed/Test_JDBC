import javax.swing.plaf.nimbus.State;
import java.util.*;
import java.sql.*;

public class prog_2 {
    private static final String url="jdbc:mysql://localhost:3306/db1";
    private static final String username="root";
    private static final String password="root";
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection=DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            String query="CREATE TABLE employee(id int(1),name VARCHAR(10));";
            statement.execute(query);
            String qu="INSERT INTO employee(id,name) VALUES(1,'amit');";
            statement.execute(qu);
            String QU="SELECT * from employee;";
            ResultSet resultSet=statement.executeQuery(QU);
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                System.out.println(id+name);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}