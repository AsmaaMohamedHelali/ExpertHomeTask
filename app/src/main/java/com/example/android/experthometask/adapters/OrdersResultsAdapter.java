/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.experthometask.adapters;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.experthometask.R;
import com.example.android.experthometask.models.orders.OrdersResultResponse;

public class OrdersResultsAdapter extends RecyclerView.Adapter<OrdersResultsAdapter.OrdersViewHolder> {


    private OrdersResultResponse ordersResult;
    private Context context;


    public OrdersResultsAdapter(OrdersResultResponse ordersResult,Context context) {
        this.ordersResult = ordersResult;
        this.context=context;
    }


    @Override
    public OrdersViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.order_results_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        OrdersViewHolder viewHolder = new OrdersViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OrdersViewHolder holder, int position) {
        holder.tvDate.setText(ordersResult.getData().get(position).OrderDate);
        holder.tvCustomerName.setText(ordersResult.getData().get(position).getCustomers().customer_name);
        holder.tvOrderId.setText(ordersResult.getData().get(position).getOrder_Id()+"");
        holder.tvTotal.setText(ordersResult.getData().get(position).getTotal()+"£");

        holder.rlOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(context, ItemDetailsActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("ITEMDetails", searchResponse.getListings().getItems().get(position));
//                intent.putExtra("bundle", bundle);
//                context.startActivity(intent);
                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        if(ordersResult.getData()!=null){
            return ordersResult.getData().size();
        }
        return 0;
    }


    class OrdersViewHolder extends RecyclerView.ViewHolder {

        TextView tvDate, tvCustomerName, tvTotal,tvOrderId;
        RelativeLayout rlOrders;

        public OrdersViewHolder(View itemView) {
            super(itemView);

            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            tvCustomerName = (TextView) itemView.findViewById(R.id.tv_customer_name);
            tvTotal = (TextView) itemView.findViewById(R.id.tv_total);
            tvOrderId = (TextView) itemView.findViewById(R.id.tv_order_id);
            rlOrders = (RelativeLayout) itemView.findViewById(R.id.rl_oders);
        }


    }
}
