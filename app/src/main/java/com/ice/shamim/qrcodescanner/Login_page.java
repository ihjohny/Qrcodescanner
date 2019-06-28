package com.ice.shamim.qrcodescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_page extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton login_btn;
    EditText UserEmail, UserPassword;
    String userEmail, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        login_btn = findViewById(R.id.button_login);
        UserEmail = findViewById(R.id.user_email);
        UserPassword = findViewById(R.id.user_password);
        login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_login) {
            userLogin();
        }
    }

    private void userLogin() {
        userEmail = UserEmail.getText().toString().trim();
        userPassword = UserPassword.getText().toString().trim();

        if (userEmail.isEmpty()) {
            UserEmail.setError("Email is required");
            UserEmail.requestFocus();
            return;
        }
        if (userPassword.isEmpty()) {
            UserPassword.setError("Password required");
            UserPassword.requestFocus();
            return;
        }

        Call<LoginResponse> call = RetrofitClient
                .getInstance().getApi().userLogin(userEmail, userPassword);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){

                    LoginResponse loginResponse = response.body();

                    if (loginResponse.getLogin()) {
                        Toast.makeText(Login_page.this, "Login Successful", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Login_page.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Login_page.this, "Login Failed", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(Login_page.this, "Login Failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(Login_page.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

}






