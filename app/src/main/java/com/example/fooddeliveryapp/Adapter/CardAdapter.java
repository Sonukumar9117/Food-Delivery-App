package com.example.fooddeliveryapp.Adapter;

import android.content.Context;
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
import com.example.fooddeliveryapp.Activity.ChangeNumberItemsListener;
import com.example.fooddeliveryapp.Activity.ManagmentCart;
import com.example.fooddeliveryapp.Domain.Foods;
import com.example.fooddeliveryapp.R;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.viewHolder>
{
    ArrayList<Foods>list;
    private ManagmentCart managmentCart;
    Context context;

    public CardAdapter(ArrayList<Foods> list,Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.list = list;
        this.context=context;
        managmentCart=new ManagmentCart(this.context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    ChangeNumberItemsListener changeNumberItemsListener;
    @NonNull
    @Override
    public CardAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflateLayout= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_cart,parent,false);
        return new viewHolder(inflateLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.viewHolder holder, int position) {
   holder.title.setText(list.get(position).getTitle());
   holder.feeEachItem.setText("Rs"+list.get(position).getPrice());
   holder.totalEachItem.setText("Rs"+(list.get(position).getNumberInCart()*list.get(position).getPrice()));
   holder.num.setText(list.get(position).getNumberInCart()+"");
        Glide.with(holder.itemView.getContext()).load(list.get(position).getImagePath())
                .transform(new CenterCrop(),new RoundedCorners(30))
                .into(holder.pic);
        holder.plusItem.setOnClickListener(view -> managmentCart.plusNumberItem(list, position, new ChangeNumberItemsListener() {
            @Override
            public void change() {
                notifyDataSetChanged();
                changeNumberItemsListener.change();
            }
        }));
        holder.minusItem.setOnClickListener(view -> managmentCart.minusNumberItem(list, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.change();
        }));
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView title,feeEachItem,plusItem,minusItem,totalEachItem,num;
        ImageView pic;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.holderTxt);
            feeEachItem=itemView.findViewById(R.id.feeEachItem);
            totalEachItem=itemView.findViewById(R.id.totalEachitem);
            plusItem=itemView.findViewById(R.id.pluscartBtn);
            minusItem=itemView.findViewById(R.id.minuscartBtn);
            num=itemView.findViewById(R.id.numItem);
            pic=itemView.findViewById(R.id.pic);
        }
    }
}
