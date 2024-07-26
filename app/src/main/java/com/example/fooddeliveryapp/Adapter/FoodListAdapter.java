package com.example.fooddeliveryapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.fooddeliveryapp.Activity.DetailActivity;
import com.example.fooddeliveryapp.Domain.Foods;
import com.example.fooddeliveryapp.R;

import java.util.ArrayList;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.viewHolder> {

    ArrayList<Foods> items;
    Context context;
    public FoodListAdapter(ArrayList<Foods> item){
        this.items=item;
    }
    @NonNull
    @Override
    public FoodListAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        View inflate= LayoutInflater.from(context).inflate(R.layout.view_holder_list_view,parent,false);
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListAdapter.viewHolder holder, int position) {
     holder.titleTxt.setText(items.get(position).getTitle());
     holder.startTxt.setText(items.get(position).getStar()+"");
     holder.timeTxt.setText(items.get(position).getTimeValue()+"min");
     holder.priceTxt.setText("$"+ items.get(position).getPrice()+"");
        Glide.with(context).load(items.get(position).getImagePath()).
                transform(new CenterCrop(),new RoundedCorners(30))
                .into(holder.pic);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("object",items.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt,startTxt,timeTxt,priceTxt;
        ImageView pic;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            priceTxt=itemView.findViewById(R.id.priceTXT);
            pic=itemView.findViewById(R.id.img);
            titleTxt=itemView.findViewById(R.id.titleTXTS);
            startTxt=itemView.findViewById(R.id.rateTxt);
            timeTxt=itemView.findViewById(R.id.timeText);
        }
    }
}
