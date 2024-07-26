package com.example.fooddeliveryapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fooddeliveryapp.R;
import com.example.fooddeliveryapp.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.loginBtns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String email=binding.userEdt.getText().toString();
            String pass=binding.userPass.getText().toString();
            if(email!=null&&pass.length()>6){
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
            }
        });

        binding.signUpBTN.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), SignUpActivity.class)));
    }
}