package servlets;

import connection.IngredientDB;
import connection.OrderDB;
import connection.PizzerieDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Ingredient;
import models.Order;
import models.Pizza;
  
@WebServlet("/edit")
public class PizzaEditServlet extends HttpServlet {
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Getting an attribute "pizza"
        String pizza = request.getParameter("pizza");
        
        // We get objects from the database in ArrayList
        ArrayList<Ingredient> ingredients = IngredientDB.select();
        ArrayList<Pizza> pizzas = PizzerieDB.select();
        ArrayList<Order> orders = OrderDB.select();
        
        request.setAttribute("pizza", pizza);        
        request.setAttribute("orders", orders);
        request.setAttribute("ingredients", ingredients);
        request.setAttribute("pizzas", pizzas);
        // The servlet sets five attributes - "pizza", "orders", "ingredients" and "pizzas"  through the 
        //HttpServletRequest object and then forwards the request to the edit.ftl page.
         
        getServletContext().getRequestDispatcher("/edit.ftl").forward(request, response);
    }
}