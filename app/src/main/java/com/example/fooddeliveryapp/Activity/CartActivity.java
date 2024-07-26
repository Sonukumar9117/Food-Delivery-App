package com.example.fooddeliveryapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.fooddeliveryapp.Adapter.CardAdapter;
import com.example.fooddeliveryapp.databinding.ActivityCartBinding;

public class CartActivity extends BaseActivity{
    private ActivityCartBinding binding;
    private ManagmentCart managmentCart;
    private RecyclerView.Adapter adapter;
    private double tax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        managmentCart=new ManagmentCart(this);
        setVariable();
        calculateCart();
        initList();

        binding.placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Order Placed",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }
    private void setVariable(){
        binding.backBtn.setOnClickListener(v->finish());
    }
    private  void calculateCart(){
        double percentTax=0.02;//2%percentTax
        double delivery=10;//Dollar
        tax=Math.round(managmentCart.getTotalFee()*percentTax*100.0)/100;//subTax
        double total=Math.round((managmentCart.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal=Math.round(managmentCart.getTotalFee()*100)/100;
        binding.totalFeeTxt.setText("$"+total);
        binding.deliveryTxt.setText("$"+tax);
        binding.tax.setText("$"+itemTotal);
        binding.totalAmount.setText("$"+(tax+total+itemTotal));
    }
    private void initList() {
        if (managmentCart.getListCart().isEmpty()) {
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scrollViewCart.setVisibility(View.GONE);
        } else {
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollViewCart.setVisibility(View.VISIBLE);
        }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            binding.cardView.setLayoutManager(linearLayoutManager);
            adapter = new CardAdapter(managmentCart.getListCart(), this, () -> calculateCart());
        binding.cardView.setAdapter(adapter);
        }


}