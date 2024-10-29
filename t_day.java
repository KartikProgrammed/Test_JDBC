import java.sql.*;
public class t_day {
    private static final String  url="jdbc:mysql://localhost:3306/db1";
    private static final String username="root";
    private static final String pswd="root";
    public static void main(String[] args){
        try {
            Class.forName("com.sql.cj.java.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection connection=DriverManager.getConnection(url,username,pswd);
            Statement statement=connection.createStatement();
            String qu="CREATE TABLE produ(id INT ,name VARCHAR(20));";
            statement.execute(qu);
            System.out.println("table created");
            String queryy="INSERT INTO produ(id,name) VALUES(?,?);";
            PreparedStatement preparedStatement=connection.prepareStatement(queryy);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"alu");
            preparedStatement.executeUpdate();
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"aluu");
            preparedStatement.executeUpdate();
            System.out.println("values inserted");
            String query="select * from produ;";
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                System.out.println(id+name);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
