/*Create a jgbc program , create a table name - product , product attributes - pid, pname, price
        Execute 3 queries
        Insert 2 products
        Update price 200
        Display all products*/
import java.util.*;
import java.sql.*;

public class test {
    private static final String url="jdbc:mysql://localhost:3306/db1";
    private static final String username="root";
    private static final String password="root";
    public static void main(String[] args){
        try {
            Class.forName("com.sql.cj.java.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            String query1="CREATE TABLE product(pid int(2),pname VARCHAR(20),price int)";
            statement.execute(query1);
            String query2="INSERT INTO product(pid,pname,price) VALUES(?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query2);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"aloooo");
            preparedStatement.setInt(3,500);
            preparedStatement.executeUpdate();
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"pyaz");
            preparedStatement.setInt(3,999);
            preparedStatement.executeUpdate();
            String query3="UPDATE product SET price=200 where pid=1;";
            statement.execute(query3);
            String query4="SELECT * FROM product;";
            ResultSet resultSet=statement.executeQuery(query4);
            while(resultSet.next()){
                int id=resultSet.getInt("pid");
                String name=resultSet.getString("pname");
                int price=resultSet.getInt("price");
                System.out.println(id+" "+name+""+price);
            }
            if(resultSet!=null){
                resultSet.close();

            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
