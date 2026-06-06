package com.b1.entity;



public class Products {

    int categoryId;
    int productId;
    float productPrice;

    public Products(){

    }

    public Products(int categoryId, int productId, float productPrice)
    {
        super();
        this.categoryId = categoryId;
        this.productId = productId;
        this.productPrice = productPrice;
    }

    public int getCategoryId(){
        return categoryId;
    }

    public int getProductId(){
        return productId;
    }

    public float getProductPrice(){
        return productPrice;
    }

    public void setProductPrice(float productPrice){
        this.productPrice = productPrice;
    }
}
