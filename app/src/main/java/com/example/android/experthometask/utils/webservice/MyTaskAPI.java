package com.example.android.experthometask.utils.webservice;


import com.example.android.experthometask.models.login.request.LoginRequest;
import com.example.android.experthometask.models.login.response.LoginResponse;
import com.example.android.experthometask.models.orders.OrdersResultResponse;
import com.example.android.experthometask.utils.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyTaskAPI {


    @POST(Constants.apiURL + "/Account/Login")
    Call<LoginResponse> login(@Body LoginRequest user);
    @GET(Constants.apiURL + "/Orders/GetOrders")
    Call<OrdersResultResponse> ordersResult();
}
