package com.example.select2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Parent_adapter extends RecyclerView.Adapter {
    private List<Parent> parentList;
    private Context context;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    Parent_adapter(Context context, List<Parent> parentList) {
        this.context = context;
        this.parentList = parentList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case Parent.TYPE1: {
                view = LayoutInflater.from(context).inflate(R.layout.parent_recyclerview, parent, false);
                return new Parent_ViewHolder(view);
            }
            case Parent.TYPE2: {
                view = LayoutInflater.from(context).inflate(R.layout.parent_recyclerview, parent, false);
                return new Parent_ViewHolder(view);
            }
            case Parent.TYPE3: {
                view = LayoutInflater.from(context).inflate(R.layout.parent_rv_type3, parent, false);
                return new Parent_Type3_ViewHolder(view);
            }
            case Parent.TYPE4: {
                view = LayoutInflater.from(context).inflate(R.layout.parent_4, parent, false);
                return new Parent_Type4_ViewHolder(view);
            }
            default: {
                return null;
            }
        }

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        final Parent parent = parentList.get(position);
        if (parent != null) {
            final Child_Adapter child_adapter;
            switch (parent.getType()) {

                case Parent.TYPE1: {
                    ((Parent_ViewHolder) holder).tittle.setText(parent.getTittle());
                    ((Parent_ViewHolder) holder).stidk.setText(Html.fromHtml(parent.getStidk()));
                    ((Parent_ViewHolder) holder).des.setText(parent.getDes());
                    child_adapter = new Child_Adapter(context, parent.type1ArrayList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(((Parent_ViewHolder) holder).parent_rv.getContext(), LinearLayoutManager.HORIZONTAL, false);
                    ((Parent_ViewHolder) holder).parent_rv.setLayoutManager(layoutManager);
                    ((Parent_ViewHolder) holder).parent_rv.setAdapter(child_adapter);
                    ((Parent_ViewHolder) holder).parent_rv.setRecycledViewPool(viewPool);
                    break;
                }
                case Parent.TYPE2: {
                    ((Parent_ViewHolder) holder).tittle.setText(parent.getTittle());
                    ((Parent_ViewHolder) holder).stidk.setText(parent.getStidk());
                    ((Parent_ViewHolder) holder).stidk.setTextColor(Color.parseColor("#c25351"));
                    ((Parent_ViewHolder) holder).des.setText(parent.getDes());
                    child_adapter = new Child_Adapter(context, parent.type1ArrayList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(((Parent_ViewHolder) holder).parent_rv.getContext(), LinearLayoutManager.HORIZONTAL, false);
                    ((Parent_ViewHolder) holder).parent_rv.setLayoutManager(layoutManager);
                    ((Parent_ViewHolder) holder).parent_rv.setAdapter(child_adapter);
                    ((Parent_ViewHolder) holder).parent_rv.setRecycledViewPool(viewPool);
                    break;
                }
                case Parent.TYPE3: {
                    ((Parent_Type3_ViewHolder) holder).wine.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent =new Intent(view.getContext(), WineMainActivity.class);
                            view.getContext().startActivity(intent);
                        }
                    });

                    break;
                }
                case Parent.TYPE4: {

                    ((Parent_Type4_ViewHolder) holder).tittle_type4.setText(parent.getTittle());
                    child_adapter = new Child_Adapter(context, parent.type1ArrayList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(((Parent_Type4_ViewHolder) holder).parent4_rv.getContext(), RecyclerView.VERTICAL, false);
                    ((Parent_Type4_ViewHolder) holder).parent4_rv.setLayoutManager(layoutManager);
                    ((Parent_Type4_ViewHolder) holder).parent4_rv.setAdapter(child_adapter);
                    ((Parent_Type4_ViewHolder) holder).parent4_rv.setRecycledViewPool(viewPool);
                    child_adapter.setItemClickListenner(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int pos = ((Parent_Type4_ViewHolder) holder).parent4_rv.indexOfChild(view);
                            Child_type child = parent.type1ArrayList.get(pos);
                            TextView textView = view.findViewById(R.id.tittlee_child4);
                            ImageView img = view.findViewById(R.id.img_child4);
                            if (!child.isClick()) {
                                img.setRotation(90);
                                textView.setMaxLines(Integer.MAX_VALUE);
                                child.setClick(true);
                            } else {
                                img.setRotation(0);
                                textView.setMaxLines(1);
                                child.setClick(false);
                            }
                        }
                    });
                    break;
                }
            }
        }
    }


    @Override
    public int getItemViewType(int position) {
        switch (parentList.get(position).getType()) {
            case 0: {
                return Parent.TYPE1;
            }
            case 1: {
                return Parent.TYPE2;
            }
            case 2: {
                return Parent.TYPE3;
            }
            case 3: {
                return Parent.TYPE4;
            }
//            case 4: {
//                return Parent.TYPE5;
//            }
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return parentList.size();
    }

    public static class Parent_ViewHolder extends RecyclerView.ViewHolder {
        private TextView tittle, des, stidk;
        private RecyclerView parent_rv;

        Parent_ViewHolder(@NonNull View itemView) {
            super(itemView);
            tittle = itemView.findViewById(R.id.tittle);
            des = itemView.findViewById(R.id.describtion);
            stidk = itemView.findViewById(R.id.stidk);
            parent_rv = itemView.findViewById(R.id.child_rv);
        }
    }

    public static class Parent_Type3_ViewHolder extends RecyclerView.ViewHolder {
        ImageView restaurant, wine, coffee, qickfix, dessert;
        TextView txres, txwine, txcoffee, txqick, txdessert, tittle;

        Parent_Type3_ViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurant = itemView.findViewById(R.id.restaurant);
            wine = itemView.findViewById(R.id.wine_icon);
            coffee = itemView.findViewById(R.id.coffee_icon);
            qickfix = itemView.findViewById(R.id.qick_fix_icon);
            dessert = itemView.findViewById(R.id.dessert_icon);
            txcoffee = itemView.findViewById(R.id.txcoffee);
            txdessert = itemView.findViewById(R.id.txdessert);
            txqick = itemView.findViewById(R.id.txquick);
            txwine = itemView.findViewById(R.id.tx_wine);
            txres = itemView.findViewById(R.id.tx_restaurant);
            tittle = itemView.findViewById(R.id.tittle_type3);
        }
    }

    public static class Parent_Type4_ViewHolder extends RecyclerView.ViewHolder {
        TextView tittle_type4;
        RecyclerView parent4_rv;

        public Parent_Type4_ViewHolder(@NonNull View itemView) {
            super(itemView);
            tittle_type4 = itemView.findViewById(R.id.tx_parent4);
            parent4_rv = itemView.findViewById(R.id.parent_rv4);
        }
    }

}
