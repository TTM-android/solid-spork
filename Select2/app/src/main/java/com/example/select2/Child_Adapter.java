package com.example.select2;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Child_Adapter extends RecyclerView.Adapter {
    private List<Child_type> type1List1;
    private Context context;
    private View.OnClickListener onItemClickListener;
    private LayoutInflater layoutInflater;

    Child_Adapter(Context context, List<Child_type> type1List1) {
        this.context = context;
        this.type1List1 = type1List1;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item;
        switch (viewType) {
            case Child_type.CTYPE1: {
                item = layoutInflater.inflate(R.layout.child_rv, parent, false);
                return new Child_ViewHolder(item);
            }
            case Child_type.CTYPE2: {
                item = layoutInflater.inflate(R.layout.child_type2, parent, false);
                return new Child2_ViewHolder(item);
            }
            case Child_type.CTYPE3: {
                item = layoutInflater.inflate(R.layout.child_type3, parent, false);
                return new Child3_ViewHolder(item);
            }
            case Child_type.CTYPE4: {
                item = layoutInflater.inflate(R.layout.child_4, parent, false);
                RecyclerView.ViewHolder holder = new Child4_ViewHolder(item);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onClick(view);
                    }
                });
                return holder;
            }
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Child_type child_type = type1List1.get(position);
        if (child_type != null) {
            switch (child_type.type) {
                case Child_type.CTYPE1: {
                    ((Child_ViewHolder) holder).img.setImageResource(child_type.img);
                    ((Child_ViewHolder) holder).content_deal.setText(child_type.getContent_deal());
                    ((Child_ViewHolder) holder).deal_date.setText(child_type.getDeal_date());
                    ((Child_ViewHolder) holder).tittle_deal.setText(child_type.getTittle_deal());

                    break;
                }
                case Child_type.CTYPE2: {
                    ((Child2_ViewHolder) holder).img2.setImageResource(child_type.img);
                    ((Child2_ViewHolder) holder).textView.setText(child_type.getTittle());
                    ((Child2_ViewHolder) holder).color_view.setBackgroundResource(child_type.getColor());
                    break;
                }
                case Child_type.CTYPE3: {
                    ((Child3_ViewHolder) holder).img3.setImageResource(child_type.getImg());
                    ((Child3_ViewHolder) holder).txName.setText(child_type.getName());
                    ((Child3_ViewHolder) holder).txDescrib.setText(child_type.getDesc());
                    ((Child3_ViewHolder) holder).txPriceSaled.setText(child_type.getPrice_saled());
                    ((Child3_ViewHolder) holder).txPrice.setText(Html.fromHtml(child_type.getPrice()));
                    //((Child3_ViewHolder) holder).txPrice.setPaintFlags(((Child3_ViewHolder) holder).txPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    break;
                }
                case Child_type.CTYPE4: {
                    ((Child4_ViewHolder)holder).img4.setImageResource(child_type.getImg());
                    ((Child4_ViewHolder) holder).textView.setText(child_type.getTittle());
                    break;
                }
            }
        }
    }


    @Override
    public int getItemViewType(int position) {
        switch (type1List1.get(position).type) {
            case 0:
                return Child_type.CTYPE1;
            case 1:
                return Child_type.CTYPE2;
            case 2:
                return Child_type.CTYPE3;
            case 3:
                return Child_type.CTYPE4;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return type1List1.size();
    }

    public class Child_ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView deal_date, tittle_deal, content_deal;

        Child_ViewHolder(View itemview) {
            super(itemview);
            img = itemview.findViewById(R.id.img_item_child);
            deal_date = itemview.findViewById(R.id.deal_date);
            tittle_deal = itemview.findViewById(R.id.tittle_deal);
            content_deal = itemview.findViewById(R.id.content_deal);
        }
    }

    public class Child2_ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img2;
        private View color_view;
        private TextView textView;

        Child2_ViewHolder(@NonNull View itemView) {
            super(itemView);
            img2 = itemView.findViewById(R.id.img_child2);
            textView = itemView.findViewById(R.id.tx_child2);
            color_view = itemView.findViewById(R.id.color_view);
        }
    }

    public class Child3_ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img3;
        private TextView txName, txDescrib, txPriceSaled, txPrice;

        Child3_ViewHolder(@NonNull View itemView) {
            super(itemView);
            img3 = itemView.findViewById(R.id.img_child3);
            txName = itemView.findViewById(R.id.txname);
            txDescrib = itemView.findViewById(R.id.txdescribtion);
            txPriceSaled = itemView.findViewById(R.id.tx_price_saled);
            txPrice = itemView.findViewById(R.id.tx_price_grid);
        }
    }
    public class Child4_ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img4;
        private TextView textView;

        Child4_ViewHolder(@NonNull View itemView) {
            super(itemView);
            img4 = itemView.findViewById(R.id.img_child4);
            textView = itemView.findViewById(R.id.tittlee_child4);
        }
    }
    public void setItemClickListenner(View.OnClickListener onClickListener){
        onItemClickListener = onClickListener;
    }


}
