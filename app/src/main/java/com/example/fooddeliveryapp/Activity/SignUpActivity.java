package com.example.fooddeliveryapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

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
                String email=binding.userEdt.getText().toString();
                String password=binding.userPass.getText().toString();
                String confirmPassword=binding.userPassConfirmation.getText().toString().trim();
                if(password.length()<6){
                    Toast.makeText(SignUpActivity.this,"Your Password must be 6 character",Toast.LENGTH_LONG).show();
                    return;
                }
                else if(!password.equals(confirmPassword)){
                    Toast.makeText(SignUpActivity.this,"Password doesn't match",Toast.LENGTH_LONG).show();
                }
                else {
                    startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                    finish();
                }



//                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isComplete()){
//                            Log.i(Tag,"onComplete");
//                        }else{
//                            Log.i(Tag,"failure:"+task.getException());
//                            Toast.makeText(SignUpActivity.this,"Authentication failed",Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
            }
        });
    }
}