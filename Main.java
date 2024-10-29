import java.sql.*;
import java.util.*;
public class Main {
    private static final String url="jdbc:mysql://localhost:3306/db1"; //put database name in the end
    private static final String username="root";
    private static final String password="root";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            //DISPLAY THE TABLE FROM DB
            String query="SELECT * from students;";
            ResultSet resultSet =statement.executeQuery(query);
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                double marks=resultSet.getDouble("marks");
                System.out.println("ID "+id);
                System.out.println("name "+name);
                System.out.println("age "+age);
                System.out.println("marks "+marks);

            }
            //INSERTING A NEW COLUMN
            /*String query=String.format("INSERT INTO students(name,age,marks) VALUES('%s',%o,%f)","rahul",23,91.2);
            int rowsAffected=statement.executeUpdate(query);
            if(rowsAffected>0){
                System.out.println("data inserted");
            }
            else {
                System.out.println("might be some error");
            }
            query="SELECT * from students;";
            ResultSet resultSet =statement.executeQuery(query);
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                double marks=resultSet.getDouble("marks");
                System.out.println("ID "+id);
                System.out.println("name "+name);
                System.out.println("age "+age);
                System.out.println("marks "+marks);
                System.out.println("\n");

            }

             */
            //UPDATE
            /*
            String query=String.format("UPDATE students SET name='%s' WHERE id=%d","Ram",1);
            int rowsaffected=statement.executeUpdate(query);
            if(rowsaffected>0){
                System.out.println("update successful");
            }
            else
                System.out.println("failed update");
            */
            //DELETE
            /*String query="DELETE FROM students WHERE id=2;";
            int rowsaffected=statement.executeUpdate(query);
            if(rowsaffected>0)
                System.out.println("successful deletion");
            else
                System.out.println("failed");*/
            //PREPARED STATEMENTS
            /*
            String query="INSERT INTO students(name,age,marks) VALUES(?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,"Lakshman");
            preparedStatement.setInt(2,21);
            preparedStatement.setDouble(3,99.99);
            int rowsaffected=preparedStatement.executeUpdate();
            if(rowsaffected>0){
                System.out.println("successful insertion");
            }else
                System.out.println("failed");*/
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}