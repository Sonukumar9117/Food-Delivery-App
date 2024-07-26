package com.example.fooddeliveryapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.fooddeliveryapp.Helper.Database;

public class SignUpActivity extends BaseActivity {
    public String Tag="FoodLover";
    com.example.fooddeliveryapp.databinding.ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= com.example.fooddeliveryapp.databinding.ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setVariable();
    }
    public void setVariable(){
        binding.loginPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });
        binding.signupBtns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=binding.userName.getText().toString();
                String userEmail=binding.userEdt.getText().toString();
                String password=binding.userPass.getText().toString();
                String confirmPassword=binding.userPassConfirmation.getText().toString().trim();

                if(userName.length()==0){
                    Toast.makeText(SignUpActivity.this,"Plx Enter user Name",Toast.LENGTH_LONG).show();
                }
                else if(userEmail.length()==0){
                    Toast.makeText(SignUpActivity.this,"Plz Enter user Email",Toast.LENGTH_LONG).show();
                }
                else if(password.length()<6){
                    Toast.makeText(SignUpActivity.this,"Your Password must be 6 character",Toast.LENGTH_LONG).show();
                    return;
                }
                else if(!password.equals(confirmPassword)){
                    Toast.makeText(SignUpActivity.this,"Password doesn't match",Toast.LENGTH_LONG).show();
                }
                else {
                    Database db=new Database(getApplicationContext(),"foodDelivery",null,1);
                    db.register(userName,userEmail,password);
                    Toast.makeText(SignUpActivity.this, "SignUp Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                    finish();
                }

            }
        });
    }
}