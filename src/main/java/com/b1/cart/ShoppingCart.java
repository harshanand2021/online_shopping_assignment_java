package com.b1.cart;

import com.b1.entity.Products;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart implements Cart {

    ArrayList<Products> allItems = new ArrayList<Products>();

    @Override
    public void addToCart(Products objProducts) {
        allItems.add(objProducts);
    }

    @Override
    public Iterator<Products> listCart() {
        return allItems.iterator();
    }
}
