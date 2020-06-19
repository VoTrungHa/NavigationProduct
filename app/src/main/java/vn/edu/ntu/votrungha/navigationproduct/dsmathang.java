package vn.edu.ntu.votrungha.navigationproduct;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.votrungha.model.Product;
import vn.edu.ntu.votrungha.Controller.IcartProduct;



public class dsmathang extends Fragment {

    RecyclerView rvlistMH;
    FloatingActionButton fab;
    NavController controller;

    IcartProduct controllerDate;
    List<Product> products;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);// hiển thị menu cho gragment
    }
    @Override
    public void onPause() {// khac activity nay bị ẩn thì hàm này được chạy, thì mũi lên được hiện lên
        super.onPause();
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        controller= NavHostFragment.findNavController(dsmathang.this);
        View view= inflater.inflate(R.layout.fragment_dsmathang, container, false);
        fab=view.findViewById(R.id.fab);
        rvlistMH=view.findViewById(R.id.rvlistMH);
        //controllerDate=(IcartProduct) getActivity().getApplication();
        controllerDate=((MainActivity)getActivity()).icartProduct;
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);// ẩn nút mũi tên .
        connectDate();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).controller=controller;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.navigate(R.id.action_dsmathang_to_product);
            }
        });
    }



    public void connectDate()
    {
        rvlistMH.setLayoutManager(new LinearLayoutManager(getActivity()));
        products=controllerDate.getListProduct();// danh sách sản phẩm
        rvlistMH.setAdapter(new ProductAdapter(products));

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main,menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.cartmn) {
            CallCartShopping();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void CallCartShopping()
    {
        controller.navigate(R.id.action_dsmathang_to_shopping);
    }


    private class ProductViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtdes,txtPri,txtName;
        ImageButton btnCart;
        Product p;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtdes=itemView.findViewById(R.id.txtDesc);
            txtName=itemView.findViewById(R.id.txtName);
            txtPri=itemView.findViewById(R.id.txtPrice);
            btnCart=itemView.findViewById(R.id.imageButton);
            btnCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!controllerDate.addToShopping(p))
                    {
                        Toast.makeText(getContext(),p.getName()+" đã toàn tại",Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(getContext(),"Thêm Sản Phẩm "+p.getName()+" vào giỏ hàng",Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
        public void bind(Product p)
        {
            this.p=p;
            txtName.setText(p.getName());
            txtPri.setText(Integer.toString(p.getPrice()));
            txtdes.setText(p.getDesc());
            btnCart.setImageResource(R.drawable.ic_action_cart);
        }
    }
    public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder>
    {

        List<Product> products;
        public ProductAdapter(List<Product> products)
        {
            this.products=products;
        }
        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view =getLayoutInflater().inflate(R.layout.showproducts,parent,false);
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            holder.bind(products.get(position));
        }

        @Override
        public int getItemCount() {
            return products.size();
        }
    }
}