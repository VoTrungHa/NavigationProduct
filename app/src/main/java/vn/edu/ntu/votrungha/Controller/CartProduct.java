package vn.edu.ntu.votrungha.Controller;

import android.app.Application;

import java.util.ArrayList;

import vn.edu.ntu.votrungha.model.Product;

public class CartProduct extends Application implements IcartProduct {

    ArrayList<Product> products=new ArrayList<>();
    ArrayList<Product> getshopping=new ArrayList<>();

    public CartProduct()
    {
//        products.add(new Product("Xoai",20000,"cát bồ lộc"));
//        products.add(new Product("Mít",10000,"mít tố nữ"));
//        products.add(new Product("mận",12000,"mận bắc"));
//        products.add(new Product("táo",20000,"Táo đaklac"));
    }


    @Override
    public ArrayList<Product> getListProduct() {
        return products;
    }

    @Override
    public boolean addToShopping(Product p) {
        if(!getshopping.contains(p))
        {
            getshopping.add(p);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Product> getShoppingCart() {
        return getshopping;
    }

    @Override
    public void clearShoppingCart() {
        getshopping.clear();
    }

    @Override
    public String getCountCart() {
        return getshopping.size()>0?new Integer(getshopping.size()).toString():"";
    }

    @Override
    public void addProduct(Product p) {
        products.add(p);
    }
}
