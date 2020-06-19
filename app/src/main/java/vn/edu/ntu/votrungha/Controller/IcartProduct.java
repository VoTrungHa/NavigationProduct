package vn.edu.ntu.votrungha.Controller;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.votrungha.model.Product;

public interface IcartProduct {
    public List<Product> getListProduct();
    public boolean addToShopping(Product p);
    public ArrayList<Product>getShoppingCart();
    public void clearShoppingCart();
    public String getCountCart();
    public void addProduct(Product p);
}
