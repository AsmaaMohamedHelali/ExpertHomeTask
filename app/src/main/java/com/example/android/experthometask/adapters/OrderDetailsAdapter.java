package com.example.android.experthometask.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.experthometask.R;
import com.example.android.experthometask.models.orders.OrderDetail;
import com.ramotion.foldingcell.FoldingCell;

import java.util.List;

/**
 * Created by asmaa on 18/05/18.
 */

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.OrderDetailsViewHolder> {


    private List<OrderDetail> orderDetailList;
    private Context context;


    public OrderDetailsAdapter(List<OrderDetail> orderDetailList,Context context) {
        this.orderDetailList = orderDetailList;
        this.context=context;
    }


    @Override
    public OrderDetailsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.order_details_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        OrderDetailsViewHolder viewHolder = new OrderDetailsViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final OrderDetailsViewHolder holder, final int position) {
        holder.tvDateInner.setText(orderDetailList.get(position).getSubcategories().getCreation_date());
        holder.tvSizeInner.setText("Size: "+orderDetailList.get(position).getSubcategories().getSubcategory_Size());
        holder.tvPriceInner.setText("Price: "+orderDetailList.get(position).getSubcategories().getSubcategory_Price()+"£");
        holder.tvQuantity.setText("Quntity: "+orderDetailList.get(position).getQuantity()+"item");
        holder.tvType.setText("Type: "+orderDetailList.get(position).getType()+"");
        holder.tvPrice.setText("Unit Price: "+orderDetailList.get(position).getUnitPrice()+"£");
        holder.tvOrderId.setText(orderDetailList.get(position).getOrderDetailId()+"");

        holder.fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.fc.toggle(false);
            }
        });
    }


    @Override
    public int getItemCount() {
        if(orderDetailList!=null){
            return orderDetailList.size();
        }
        return 1;
    }


    class OrderDetailsViewHolder extends RecyclerView.ViewHolder {
        FoldingCell fc;
        TextView tvDateInner,tvSizeInner,tvPriceInner,tvQuantity,
                tvType,tvPrice,tvOrderId;

        public OrderDetailsViewHolder(View itemView) {
            super(itemView);
            fc = (FoldingCell) itemView.findViewById(R.id.folding_cell);
            tvDateInner = (TextView) itemView.findViewById(R.id.tv_date_inner);
            tvSizeInner = (TextView) itemView.findViewById(R.id.tv_size_inner);
            tvPriceInner = (TextView) itemView.findViewById(R.id.tv_price_inner);
            tvQuantity = (TextView) itemView.findViewById(R.id.tv_quantity);
            tvOrderId = (TextView) itemView.findViewById(R.id.tv_order_id);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
            tvType = (TextView) itemView.findViewById(R.id.tv_type);


        }


    }
}

