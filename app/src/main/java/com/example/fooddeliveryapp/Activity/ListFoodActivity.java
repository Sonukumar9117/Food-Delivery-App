package com.example.fooddeliveryapp.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.Adapter.FoodListAdapter;
import com.example.fooddeliveryapp.Domain.Foods;
import com.example.fooddeliveryapp.databinding.ActivityListFoodBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListFoodActivity extends BaseActivity{
   ActivityListFoodBinding binding;
    private RecyclerView.Adapter adapterListFood;
    private  int categoryId;
    private String categoryName;
    public  String searchText;
    private  boolean isSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityListFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getIntentExtra();
        initList();
    }
    private  void getIntentExtra(){
        categoryId =getIntent().getIntExtra("CategoryId",0);
        categoryName=getIntent().getStringExtra("Category");
        searchText=getIntent().getStringExtra("text");
        isSearch=getIntent().getBooleanExtra("isSearch",false);
        binding.holderTxt.setText(categoryName);
        binding.backbtn.setOnClickListener(V->finish());
    }
    private void initList(){
        DatabaseReference myRef= database.getReference("Foods");
        binding.foodListProgressBar.setVisibility(View.VISIBLE);
        ArrayList<Foods>list=new ArrayList<>();
        Query query;
        if(isSearch){
            query=myRef.orderByChild("Title").startAt(searchText).endAt(searchText+'\uf8ff');
        }else{
            query=myRef.orderByChild("CategoryId").equalTo(categoryId);
        }
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issue:snapshot.getChildren())
                         list.add(issue.getValue(Foods.class));
                }
                if(list.size()>0){
                    binding.foodListView.setLayoutManager(new GridLayoutManager(ListFoodActivity.this,2));
                    adapterListFood=new FoodListAdapter(list);
                    binding.foodListView.setAdapter(adapterListFood);
                }
                binding.foodListProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}