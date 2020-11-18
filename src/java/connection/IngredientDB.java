package connection;
 
import java.sql.*;
import java.util.ArrayList;
import models.Ingredient;
 
public class IngredientDB {
 
    private static String url = "jdbc:mysql://localhost:3306/barbershop?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "11111111";
    
    // The class defines all basic database operations. The select () 
    // method gets all the data from the products table and creates a list of Ingredient objects from it.
    public static ArrayList<Ingredient> select() {
         
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        try{
            // Driver download
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Connection object is created to interact with the database
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM `pizzeria`.`ingredients`");
                // ResultSet executeQuery (): Executes a SELECT command that returns data as a ResultSet
                while(resultSet.next()){
                      
                    // get the contents of the lines
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int price = resultSet.getInt(3);
                    // The first and third column in the table, the id and price column, is of type int, so the getInt () method is used to get it. 
                    // The second column, name, represents a string, so the getString () method is used to get its data.
                    Ingredient product = new Ingredient(id, name, price);
                    ingredients.add(product);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return ingredients;
    }

}