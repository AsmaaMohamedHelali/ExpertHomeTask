package com.example.android.experthometask.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.experthometask.R;
import com.example.android.experthometask.models.login.request.LoginRequest;
import com.example.android.experthometask.models.login.response.LoginResponse;
import com.example.android.experthometask.utils.Localization;
import com.example.android.experthometask.utils.MyTaskApp;
import com.example.android.experthometask.utils.network.NetworkUtil;
import com.example.android.experthometask.utils.webservice.MyTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.progressbar)
    ContentLoadingProgressBar loadingProgressBar;
    @BindView(R.id.et_user_name)
    EditText userName;
    @BindView(R.id.et_user_password)
    EditText userPassword;

    @OnClick(R.id.btn_login)
    public void register(Button button) {
        if (validate()) {
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            loadingProgressBar.setVisibility(View.VISIBLE);
            checkNetwork();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Localization.setLocale(this, "en");
    }

    private void checkNetwork() {
        switch (NetworkUtil.getConnectivityStatus(this)) {
            case OFFLINE:
                loadingProgressBar.setVisibility(View.GONE);
                Toast.makeText(this, getString(R.string.offline), Toast.LENGTH_LONG).show();
                break;
            case WIFI_CONNECTED_WITHOUT_INTERNET:
                loadingProgressBar.setVisibility(View.GONE);
                Toast.makeText(this, getString(R.string.offline), Toast.LENGTH_LONG).show();
                break;
            case MOBILE_DATA_CONNECTED:
            case WIFI_CONNECTED_WITH_INTERNET:
                callLoginService();
                break;
        }
    }

    private void callLoginService() {
        Call<LoginResponse> call =
                MyTask.getInstance().getMyAppService().login(new LoginRequest(userName.getText().toString().trim(),
                        userPassword.getText().toString()));
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                loadingProgressBar.setVisibility(View.GONE);
                if(response.isSuccessful()){
                    LoginResponse result=response.body();
                    if(result!=null){
                        Intent nextActivity = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(nextActivity);
                    }else {
                        Toast.makeText(LoginActivity.this, getString(R.string.invalid_data), Toast.LENGTH_SHORT).show();

                    }

                }else {
                    Toast.makeText(LoginActivity.this, getString(R.string.invalid_data), Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loadingProgressBar.setVisibility(View.GONE);
                Toast.makeText(LoginActivity.this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public boolean validate() {
        boolean valid = true;

        if (userName.getText().toString().trim().isEmpty()) {
            userName.setError(getString(R.string.empty_field));
            valid = false;
        } else {
            userName.setError(null);
        }

        if (userPassword.getText().toString().isEmpty()) {
            userPassword.setError(getString(R.string.empty_field));
            valid = false;
        } else {
            userPassword.setError(null);
        }

        return valid;
    }
}
