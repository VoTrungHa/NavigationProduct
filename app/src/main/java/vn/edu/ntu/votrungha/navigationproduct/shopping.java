package vn.edu.ntu.votrungha.navigationproduct;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.edu.ntu.votrungha.Controller.CartProduct;
import vn.edu.ntu.votrungha.Controller.IcartProduct;
import vn.edu.ntu.votrungha.model.Product;

public class shopping extends Fragment {



    NavController controller;
    TextView txttitle,txtPro;
    Button btnAdd,btnDel;
    IcartProduct cartProduct;
    public shopping() {
        // Required empty public constructor

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_shopping, container, false);

        addview(view);
        getDateCart();
        addevent();
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        controller= NavHostFragment.findNavController(this);
        ((MainActivity)getActivity()).controller=controller;

    }
    public  void addview(View view)
    {
        txtPro=view.findViewById(R.id.txtPruduct);
        txttitle=view.findViewById(R.id.txttitle);
        btnAdd=view.findViewById(R.id.btnaddCart);
        btnDel=view.findViewById(R.id.btnDeleteCart);
    }

    public void addevent()
    {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                controller.navigate(R.id.action_shopping_to_comfirm);
            }
        });
    }

    private void getDateCart()
    {
       // cartProduct=(IcartProduct) getActivity().getApplication();
        cartProduct=((MainActivity)getActivity()).icartProduct;
        ArrayList<Product> products=cartProduct.getShoppingCart();
        StringBuilder builder=new StringBuilder();
        for(Product item:products)
        {
            builder.append(item.getName() +" " + item.getPrice()+"VND\n");
        }
        if(builder.toString().length()>0)
        {
            txtPro.setText(builder.toString());
        }
        else
        {
            txtPro.setText("Không có sản phẩm nào");
        }
    }
}