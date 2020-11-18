package models;

public class Order {
    
    private int id;
    private String pizza;
    private String ingredients;
    private int price;

    public Order() {
    }

    public Order(int id, String pizza, String ingredients, int price) {
        this.id = id;
        this.pizza = pizza;
        this.ingredients = ingredients;
        this.price = price;
    }

    public Order(String pizza, String ingredients, int price) {
        this.pizza = pizza;
        this.ingredients = ingredients;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
}
