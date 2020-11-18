package connection;
 
import java.sql.*;
import java.util.ArrayList;
import models.Order;
 
public class OrderDB {
 
    private static String url = "jdbc:mysql://localhost:3306/barbershop?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "11111111";
    
    // The class defines all basic database operations. The select () 
    // method gets all the data from the products table and creates a list of Order objects from it.
    public static ArrayList<Order> select() {
         
        ArrayList<Order> orders = new ArrayList<Order>();
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Connection object is created to interact with the database
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM `pizzeria`.`orders`");
                // ResultSet executeQuery (): Executes a SELECT command that returns data as a ResultSet
                while(resultSet.next()){
                     
                    // get the contents of the lines 
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String ingredients = resultSet.getString(3);
                    int price = resultSet.getInt(4);
                    // The first and fourth column in the table, the id and price column, is of type int, so the getInt () method is used to get it. 
                    // The second and third column, name and ingredient, represents a string, so the getString () method is used to get its data.
                    Order product = new Order(id, name, ingredients, price);
                    orders.add(product);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return orders;
    }

    public static int insert(Order order) {
         
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO `pizzeria`.`orders` (pizza, ingredients, price) VALUES (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, order.getPizza());
                    preparedStatement.setString(2, order.getIngredients());
                    preparedStatement.setInt(3, order.getPrice());
                    // executes SQL commands like INSERT
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

}