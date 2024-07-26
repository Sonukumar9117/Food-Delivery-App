package com.example.fooddeliveryapp.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;


import com.example.fooddeliveryapp.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {
    ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setVariable();
        getWindow().setStatusBarColor(Color.parseColor("#FFE4B5"));
    }
    private  void setVariable(){
        binding.loginBtn.setOnClickListener(view -> {

        });
        binding.signupBtn.setOnClickListener(view -> {

        });
    }
}