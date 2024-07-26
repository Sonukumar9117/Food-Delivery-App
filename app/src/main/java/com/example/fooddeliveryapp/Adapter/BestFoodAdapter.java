package com.example.fooddeliveryapp.Adapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.fooddeliveryapp.Activity.DetailActivity;
import com.example.fooddeliveryapp.Domain.Foods;
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

public class BestFoodAdapter extends RecyclerView.Adapter<BestFoodAdapter.viewHolder> {
    ArrayList<Foods>items;
    Context context;
    public  BestFoodAdapter(ArrayList<Foods>items){
        this.items=items;

    }
    @NonNull
    @Override
    public BestFoodAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_best_deal,parent,false);
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.priceTxt.setText("$" + items.get(position).getPrice());
        holder.starTxt.setText("" + items.get(position).getStar());
        holder.timeTxt.setText(items.get(position).getTimeValue() + "min");

            Glide.with(context)
                    .load(items.get(position).getImagePath())
                    .transform(new MultiTransformation<>(new CenterCrop(), new RoundedCorners(30)))
                    .into(holder.pic);
        holder.itemView.setOnClickListener(view -> {
            Intent intent=new Intent(context, DetailActivity.class);
            intent.putExtra("object",items.get(position));
            context.startActivity(intent);
        });
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt,priceTxt,starTxt,timeTxt;
        ImageView pic;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt=itemView.findViewById(R.id.titleTxt);
            priceTxt=itemView.findViewById(R.id.priceTxt);
            starTxt=itemView.findViewById(R.id.starTxt);
            timeTxt=itemView.findViewById(R.id.timeTxt);
            pic=itemView.findViewById(R.id.pic);
        }
    }
}
