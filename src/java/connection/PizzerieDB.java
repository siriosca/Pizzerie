package connection;
 
import java.sql.*;
import java.util.ArrayList;
import models.Pizza;
 
public class PizzerieDB {
 
    private static String URL = "jdbc:mysql://localhost:3306/barbershop?serverTimezone=Europe/Moscow&useSSL=false";
    private static String USERNAME = "root";
    private static String PASSWORD = "11111111";
    
    // The class defines all basic database operations. The select () 
    // method gets all the data from the products table and creates a list of Pizza objects from it.
    public static ArrayList<Pizza> select() {
         
        ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Connection object is created to interact with the database
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
                  
                Statement statement = conn.createStatement();
                // send sql query to the database
                ResultSet resultSet = statement.executeQuery("SELECT * FROM `pizzeria`.`pizza`");
                while(resultSet.next()){
                      
                    // get the contents of the lines
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int price = resultSet.getInt(3);
                    String ingredient = resultSet.getString(4);
                    Pizza product = new Pizza(id, name, price, ingredient);
                    pizzas.add(product);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return pizzas;
    }
}