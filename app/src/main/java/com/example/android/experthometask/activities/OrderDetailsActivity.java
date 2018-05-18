package com.example.android.experthometask.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.example.android.experthometask.R;
import com.example.android.experthometask.adapters.OrderDetailsAdapter;
import com.example.android.experthometask.models.orders.OrderDetail;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailsActivity extends AppCompatActivity {
    private List<OrderDetail> orderDetailList;
    @BindView(R.id.rv_resultDetails)
    RecyclerView rvResultDetails;

    private OrderDetailsAdapter orderDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        ButterKnife.bind(this);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getIntentData();
        initRecyclerView();

    }
    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvResultDetails.setLayoutManager(layoutManager);

        /*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         */
        rvResultDetails.setHasFixedSize(true);

        // COMPLETED (13) Pass in this as the ListItemClickListener to the GreenAdapter constructor
        /*
         * The GreenAdapter is responsible for displaying each item in the list.
         */
        orderDetailsAdapter = new OrderDetailsAdapter(orderDetailList,this);
        rvResultDetails.setAdapter(orderDetailsAdapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);

    }

    public void getIntentData() {
        orderDetailList= (List<OrderDetail>) getIntent().getExtras().getSerializable("DETAILS");
    }
}
