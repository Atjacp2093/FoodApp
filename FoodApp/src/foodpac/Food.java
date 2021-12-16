/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodpac;

/**
 *
 * @author atjacp2093
 */
public class Food {
    private int id;
    private String name;
    private float price;
    private String properties;
    public Food(){
        
    }
    public Food(int id, String name, float price, String properties){
        this.id = id;
        this.name = name;
        this.price = price;
        this.properties = properties;
    }
    public Food(String name, float price, String properties){
        this.name = name;
        this.price = price;
        this.properties = properties;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
}
