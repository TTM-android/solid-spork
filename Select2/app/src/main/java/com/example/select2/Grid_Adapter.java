package com.example.select2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Grid_Adapter extends RecyclerView.Adapter<Grid_Adapter.ViewHolder> {
    ArrayList<GridModel> gridModelArrayList;
    Context context;

    public Grid_Adapter(ArrayList<GridModel> gridModelArrayList, Context context) {
        this.gridModelArrayList = gridModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gridview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GridModel gridModel = gridModelArrayList.get(position);
        if (gridModel != null) {
            holder.img_wine.setImageResource(gridModel.getImg_wine());
            if (gridModel.isHot) {
                holder.img_hot.setImageResource(R.drawable.hot_label);
            }else{
                holder.img_hot.setVisibility(View.INVISIBLE);
            }
            holder.tx_name.setText(gridModel.getName());
            holder.tx_price.setText(gridModel.getPrice());
            holder.tx_content.setText(gridModel.getContent());
            if(gridModel.isFreeship()){
                holder.freeship.setText(context.getResources().getString(R.string.freeshipping));
            }
        }
    }

    @Override
    public int getItemCount() {
        return gridModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_wine, img_hot;
        TextView tx_name, tx_content, tx_price, freeship;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_wine = itemView.findViewById(R.id.img_wine);
            img_hot = itemView.findViewById(R.id.img_hot);
            tx_content = itemView.findViewById(R.id.tx_content_grid);
            tx_name = itemView.findViewById(R.id.tx_name_grid);
            tx_price = itemView.findViewById(R.id.tx_price_grid);
            freeship = itemView.findViewById(R.id.freeship);
        }
    }
}
