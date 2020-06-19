package vn.edu.ntu.votrungha.navigationproduct;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.edu.ntu.votrungha.Controller.IcartProduct;
import vn.edu.ntu.votrungha.model.Product;


public class product extends Fragment {

    NavController controller;
    EditText ten,price,des;
    Button add;
    IcartProduct product;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //product =(IcartProduct) getActivity().getApplication();
        product=((MainActivity)getActivity()).icartProduct;
        View view= inflater.inflate(R.layout.fragment_product, container, false);
        addView(view);
        addevent();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller= NavHostFragment.findNavController(this);
        ((MainActivity)getActivity()).controller=controller;

    }

    public void addView(View view)
    {

        ten=view.findViewById(R.id.ten);
        price=view.findViewById(R.id.gia);
        des=view.findViewById(R.id.des);
        add=view.findViewById(R.id.them);
    }
    public void addevent()
    {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.addProduct(new Product(ten.getText().toString(),des.getText().toString(),Integer.parseInt(price.getText().toString())));
                Toast.makeText(getActivity(),"Đã thêm sản phẩm mới",Toast.LENGTH_SHORT).show();
                controller.navigate(R.id.action_product_to_dsmathang);
            }
        });
    }


}