package servlets;

import connection.IngredientDB;
import connection.OrderDB;
import connection.PizzerieDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Ingredient;
import models.Order;
import models.Pizza;
  
@WebServlet("/")
public class HomeServlet extends HttpServlet {
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // We get objects from the database in ArrayList
        ArrayList<Pizza> pizzas = PizzerieDB.select();
        ArrayList<Ingredient> ingredients = IngredientDB.select();
        ArrayList<Order> orders = OrderDB.select();
        
        
        request.setAttribute("pizzas", pizzas);
        request.setAttribute("orders", orders);
        request.setAttribute("ingredients", ingredients);
        // The servlet sets 3 attributes - "pizzas", "orders" and "ingredients"  through the 
        //HttpServletRequest object and then forwards the request to the home.ftl page.
        
        getServletContext().getRequestDispatcher("/home.ftl").forward(request, response);
    }
}