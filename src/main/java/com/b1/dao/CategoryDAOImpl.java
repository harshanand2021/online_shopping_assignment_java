package com.b1.dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.b1.entity.Category;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class CategoryDAOImpl {

    Connection connection;
    PreparedStatement psAllCategories;

    public CategoryDAOImpl() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/ecommerce_project", "root", "cdac");
            psAllCategories = connection.prepareStatement("select * from category");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Iterator<Category> getAllCategories() throws SQLException {
        try{
            ArrayList<Category> allCategories = new ArrayList<>();
            ResultSet result = psAllCategories.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
            throw new NullPointerException("Unable to get all categories");
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {}
}
