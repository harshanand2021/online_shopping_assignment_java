package com.b1.dao;

import com.b1.entity.Category;

import java.sql.SQLException;
import java.util.Iterator;

public interface CategoryDAO {

    public Iterator<Category> getAllCategories() throws SQLException;

    public void close();
}
