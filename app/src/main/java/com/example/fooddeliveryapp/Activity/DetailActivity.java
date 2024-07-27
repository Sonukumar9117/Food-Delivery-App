package com.example.fooddeliveryapp.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.fooddeliveryapp.Domain.Foods;
import com.example.fooddeliveryapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    private Foods object;
    private int num=0;
    private ManagmentCart managmentCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setVariable();

    }

    private void setVariable() {
        managmentCart=new ManagmentCart(this);
        binding.backBtn.setOnClickListener(v->finish());

//        Glide.with(DetailActivity.this).load(object.getImagePath()).into(binding.detailPic);
        Glide.with(DetailActivity.this).load(object.getImagePath()).transform(new CenterCrop(),new RoundedCorners(30),new FitCenter()).into(binding.detailPic);
        binding.priceTT.setText("Rs"+object.getPrice());
        binding.timeTxt.setText(object.getTimeValue()+"min");
        binding.titleTxt.setText(object.getTitle());
        binding.descriptionTxt.setText(object.getDescription());
        binding.rateTxt.setText(object.getStar()+" Rating");
        binding.ratingBar.setRating((float) object.getStar());
        binding.totalPriceTxt.setText(num*object.getPrice()+"$");
        binding.quantityPlus.setOnClickListener(view -> {
            num=num+1;
            binding.numTxt.setText(num+"");
            binding.totalPriceTxt.setText("Rs"+(num*object.getPrice())+"");
        });
        binding.quantityMinus.setOnClickListener(view -> {
            if(num!=0){
                num=num-1;
                binding.numTxt.setText(num+"");
                binding.totalPriceTxt.setText("Rs"+(num*object.getPrice()));
            }
        });
        binding.addTocartBtn.setOnClickListener(view -> {
            object.setNumberInCart(num);
            managmentCart.insertFood(object);
            startActivity(new Intent(getApplicationContext(),CartActivity.class));
            finish();
        });
    }

    public void getIntentExtra(){
        object=(Foods)getIntent().getSerializableExtra("object");
    }
}