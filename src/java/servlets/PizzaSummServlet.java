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
  
@WebServlet("/summ")
public class PizzaSummServlet extends HttpServlet {
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
         
        // Getting an attribute "summPizza" and "summIngredient"
        String summPizza = request.getParameter("summPizza");
        String[] summIngredient = request.getParameterValues("summIngredient");
        
        // We get objects from the database in ArrayList
        ArrayList<Ingredient> ingredients = IngredientDB.select();
        ArrayList<Pizza> pizzas = PizzerieDB.select();
        ArrayList<Order> orders = OrderDB.select();
        
        request.setAttribute("summPizza", summPizza);
        request.setAttribute("summIngredient", summIngredient);
        request.setAttribute("orders", orders);
        request.setAttribute("ingredients", ingredients);
        request.setAttribute("pizzas", pizzas);
        // The servlet sets five attributes - "summPizza", "summIngredient", "orders", "ingredients" and "pizzas"  through the 
        //HttpServletRequest object and then forwards the request to the summ.ftl page.
         
        
        // If we access the PizzaSummServlet(/summ), it will pass the request and data to the summ.ftl page.
        getServletContext().getRequestDispatcher("/summ.ftl").forward(request, response);
    }
    
        protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

                try {
                    
        // Getting attribute "summPizza" and "summIngredient"            
        String pizza = request.getParameter("pizza");
        String ingredients = request.getParameter("ingredients");
        int price = Integer.parseInt(request.getParameter("price"));
        Order order = new Order(pizza, ingredients, price); 
        OrderDB.insert(order);
        String path = request.getContextPath() + "/";
        response.sendRedirect(path);
        
        }  catch(Exception ex) {
            System.out.println(ex);
        }

}

}