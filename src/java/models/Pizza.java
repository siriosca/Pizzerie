package models;

public class Pizza {
    
    private int id;
    private String name;
    private int price;
    private String ingredients;

    public Pizza(int id, String name, int price, String ingredients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients=ingredients;
    }

    public Pizza(String name, int price, String ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients=ingredients;
    }

    public Pizza() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    
    
    
}
