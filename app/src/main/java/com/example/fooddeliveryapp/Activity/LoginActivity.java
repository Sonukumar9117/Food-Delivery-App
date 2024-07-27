package com.example.fooddeliveryapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fooddeliveryapp.Helper.Database;
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
                Database db=new Database(LoginActivity.this,"foodDelivery",null,1);

            if(email!=null&&pass.length()>6){
                if(db.login(email,pass)==1){
                    SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    //to save the data with key and value
                    editor.putString("username",email);
                    editor.apply();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
                else Toast.makeText(LoginActivity.this, "Invalid user name or password", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(LoginActivity.this, "Plz enter user name and password ", Toast.LENGTH_SHORT).show();
            }
            }
        });

        binding.signUpBTN.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), SignUpActivity.class)));
    }
}