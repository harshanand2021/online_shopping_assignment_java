package com.b1.cart;

import com.b1.entity.Products;
import java.util.Iterator;

public interface Cart {

    public void addToCart(Products objProducts);
    public Iterator<Products> listCart();
}
