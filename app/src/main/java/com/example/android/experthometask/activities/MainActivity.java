package com.example.android.experthometask.activities;

import android.content.Intent;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.experthometask.R;
import com.example.android.experthometask.adapters.OrdersResultsAdapter;
import com.example.android.experthometask.models.orders.OrdersResultResponse;
import com.example.android.experthometask.utils.network.NetworkUtil;
import com.example.android.experthometask.utils.webservice.MyTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_results)
    RecyclerView rvResults;
    @BindView(R.id.progressbar)
    ContentLoadingProgressBar loadingProgressBar;

    private OrdersResultsAdapter orderResultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loadingProgressBar.setVisibility(View.VISIBLE);
        checkNetwork();

    }

    private void checkNetwork() {
        switch (NetworkUtil.getConnectivityStatus(this)) {
            case OFFLINE:
                loadingProgressBar.setVisibility(View.GONE);
                Toast.makeText(this, getString(R.string.offline), Toast.LENGTH_SHORT).show();
                break;
            case WIFI_CONNECTED_WITHOUT_INTERNET:
                loadingProgressBar.setVisibility(View.GONE);
                Toast.makeText(this, getString(R.string.offline), Toast.LENGTH_SHORT).show();
                break;
            case MOBILE_DATA_CONNECTED:
            case WIFI_CONNECTED_WITH_INTERNET:
                callOrdersResultService();
                break;
        }
    }

    private void callOrdersResultService() {
        Call<OrdersResultResponse> call =
                MyTask.getInstance().getMyAppService().ordersResult();
        call.enqueue(new Callback<OrdersResultResponse>() {
            @Override
            public void onResponse(Call<OrdersResultResponse> call, Response<OrdersResultResponse> response) {
                loadingProgressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    OrdersResultResponse result = response.body();
                    if (result != null) {
                        Toast.makeText(MainActivity.this, "yes", Toast.LENGTH_LONG).show();
//                        initRecyclerView();
                    } else {
                        Toast.makeText(MainActivity.this, getString(R.string.invalid_data), Toast.LENGTH_LONG).show();

                    }

                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.invalid_data), Toast.LENGTH_LONG).show();

                }


            }

            @Override
            public void onFailure(Call<OrdersResultResponse> call, Throwable t) {
                loadingProgressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvResults.setLayoutManager(layoutManager);

        /*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         */
        rvResults.setHasFixedSize(true);

        // COMPLETED (13) Pass in this as the ListItemClickListener to the GreenAdapter constructor
        /*
         * The GreenAdapter is responsible for displaying each item in the list.
         */
        orderResultAdapter = new OrdersResultsAdapter(this);
        rvResults.setAdapter(orderResultAdapter);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);

    }
}
