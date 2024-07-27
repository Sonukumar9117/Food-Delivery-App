package com.example.fooddeliveryapp.Adapter;
import com.bumptech.glide.Glide;
import com.example.fooddeliveryapp.Activity.ListFoodActivity;
import com.example.fooddeliveryapp.Domain.Category;
import com.example.fooddeliveryapp.R;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewholder> {
    ArrayList<Category>items;
    Context context;
    public CategoryAdapter(ArrayList<Category>items){
        this.items=items;

    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_category,parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
           holder.titleTxt.setText(items.get(position).getName());
        switch (position){
            case 0:{
                holder.pic.setBackgroundResource(R.drawable.cat_0_background);
                Glide.with(context).load(R.drawable.btn_0).into(holder.pic);
                break;
            }
            case 1:{
                holder.pic.setBackgroundResource(R.drawable.cat_1_background);
                Glide.with(context).load(R.drawable.btn_1).into(holder.pic);
                break;
            }
            case 2:{
                holder.pic.setBackgroundResource(R.drawable.cat_2_background);
                Glide.with(context).load(R.drawable.btn_2).into(holder.pic);
                break;
            }
            case 3:{
                holder.pic.setBackgroundResource(R.drawable.cat_3_background);
                Glide.with(context).load(R.drawable.btn_3).into(holder.pic);
                break;
            }
            case 4:{
                holder.pic.setBackgroundResource(R.drawable.cat_4_background);
                Glide.with(context).load(R.drawable.btn_4).into(holder.pic);
                break;
            }
            case 5:{
                holder.pic.setBackgroundResource(R.drawable.cat_5_background);
                Glide.with(context).load(R.drawable.btn_5).into(holder.pic);
                break;
            }
            case 6:{
                holder.pic.setBackgroundResource(R.drawable.cat_6_background);
                Glide.with(context).load(R.drawable.btn_6).into(holder.pic);
                break;
            }
            case 7:{
                holder.pic.setBackgroundResource(R.drawable.cat_7_background);
                Glide.with(context).load(R.drawable.btn_7).into(holder.pic);
                break;
            }
        }
//        int drawableResourceId=context.getResources().getIdentifier(items.get(position).getImagePath(),"drawable",holder.itemView.getContext().getPackageName());
//        Glide.with(context).load(drawableResourceId-1)
//                .into(holder.pic);


        holder.itemView.setOnClickListener(view -> {
            Intent intent=new Intent(context, ListFoodActivity.class);
            intent.putExtra("CategoryId",items.get(position).getId());
            intent.putExtra("CategoryName",items.get(position).getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public class viewholder extends RecyclerView.ViewHolder {
        TextView titleTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            titleTxt=itemView.findViewById(R.id.catNameTxt);
            pic=itemView.findViewById(R.id.imgCat);
        }
    }
}
