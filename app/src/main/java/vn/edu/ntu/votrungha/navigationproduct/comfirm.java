package vn.edu.ntu.votrungha.navigationproduct;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.ntu.votrungha.Controller.IcartProduct;
import vn.edu.ntu.votrungha.model.Product;

public class comfirm extends Fragment {

    TextView txtbuy;
    IcartProduct icartProduct;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_comfirm, container, false);
        txtbuy=view.findViewById(R.id.databuy);
        getdata();
        return view;
    }

    public void getdata()
    {
        icartProduct =((MainActivity)getActivity()).icartProduct;

        ArrayList<Product> products=icartProduct.getShoppingCart();
        StringBuilder builder=new StringBuilder();
        for(Product item:products)
        {
            builder.append(item.getName() +" " + item.getPrice()+"\n");
        }
        if(builder.toString().length()>0)
        {
            txtbuy.setText(builder.toString());
        }
        else
        {
            txtbuy.setText("Không có sản phẩm nào");
        }
    }
}