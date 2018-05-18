package com.example.android.experthometask.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.experthometask.R;
import com.ramotion.foldingcell.FoldingCell;

/**
 * Created by asmaa on 18/05/18.
 */

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.OrderDetailsViewHolder> {


//    private OrdersResultResponse ordersResult;
    private Context context;


    public OrderDetailsAdapter(Context context) {
//        this.ordersResult = ordersResult;
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
//        holder.tvDate.setText(ordersResult.getData().get(position).getOrderDate());
//        holder.tvCustomerName.setText(ordersResult.getData().get(position).getCustomers().getCustomer_name());
//        holder.tvOrderId.setText(ordersResult.getData().get(position).getOrder_Id()+"");
//        holder.tvTotal.setText(ordersResult.getData().get(position).getTotal()+"£");
//
        holder.fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.fc.toggle(false);
            }
        });
    }


    @Override
    public int getItemCount() {
//        if(ordersResult.getData()!=null){
//            return ordersResult.getData().size();
//        }
        return 1;
    }


    class OrderDetailsViewHolder extends RecyclerView.ViewHolder {
        FoldingCell fc;

        public OrderDetailsViewHolder(View itemView) {
            super(itemView);
              fc = (FoldingCell) itemView.findViewById(R.id.folding_cell);


        }


    }
}

