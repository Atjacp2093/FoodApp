/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodpac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author atjacp2093
 */
public class foodModify {
     public static List<Food> findAll() {
        List<Food> foods = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach food
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodmanagement", "root", "");
            
            //query
            String sql = "select * from food";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                Food std = new Food(resultSet.getInt("id"), 
                        resultSet.getString("name"), resultSet.getFloat("price"), 
                        resultSet.getString("properties"));
                foods.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(foodModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(foodModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(foodModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return foods;
    }
    
    public static void insert(Food fd){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
              
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodmanagement", "root", "");
            //query
            String sql = "insert into food(name, price, properties) values(?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, fd.getName());
            statement.setFloat(2, fd.getPrice());
            statement.setString(3, fd.getProperties());
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(foodModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(foodModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(foodModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void update(Food fd){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
              
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306//foodmanagement", "root", "");
            //query
            String sql = "update food set name = ?, price= ?, properties= ? where id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, fd.getName());
            statement.setFloat(2, fd.getPrice());
            statement.setString(3, fd.getProperties());
            
            statement.execute();
            

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(foodModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }finally{
            if(statement!= null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(foodModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
            if(connection!= null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(foodModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodmanagement", "root", "");
            
            //query
            String sql = "delete from food where id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(foodModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(foodModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(foodModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static List<Food> findByFullname(String name) {
        List<Food> foodslist = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodmanagement", "root", "");
            
            //query
            String sql = "select * from food where name like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+name+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Food foods = new Food(resultSet.getInt("id"), 
                        resultSet.getString("name"), resultSet.getFloat("price"), 
                        resultSet.getString("properties"));
                foodslist.add(foods);
            }
        } catch (SQLException ex) {
            Logger.getLogger(foodModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(foodModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(foodModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return foodslist;
    }
}
