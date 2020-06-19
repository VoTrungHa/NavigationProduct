package vn.edu.ntu.votrungha.Controller;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.votrungha.model.AppDateBase;
import vn.edu.ntu.votrungha.model.DaoProduct;
import vn.edu.ntu.votrungha.model.Product;

public class ControllerDB implements IcartProduct{

    AppDateBase dateBase;
    ArrayList<Product> getshopping=new ArrayList<>();
    DaoProduct daoProduct;

    public ControllerDB(Context context)
    {
        dateBase= Room.databaseBuilder(context,AppDateBase.class,"myapp")
                .allowMainThreadQueries()// thực hiện quay về luồng chính
                .build();// trả về cho  AppDateBase dateBase;
        daoProduct=dateBase.getProductDao();// đùng để sử dùng các giao diện của nó đã khai bào trong class.
    }



    @Override
    public List<Product> getListProduct() {
        return daoProduct.getListProducts();
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
        daoProduct.insertProduct(p);
    }
}
