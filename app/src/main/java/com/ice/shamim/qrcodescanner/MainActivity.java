package com.ice.shamim.qrcodescanner;

import android.app.Activity;
import android.content.Intent;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static TextView personText,emailText,percentText;
    private static AppCompatButton scanBtn;
    private static ImageView requestImage,resultImage;
    private static TextView statusText;
    private static EditText qrText;
    private static ProgressBar progressBar;
    private static String scanResult;
    private static String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personText = findViewById(R.id.person_text);
        emailText = findViewById(R.id.email_text);
        percentText = findViewById(R.id.percent_text);
        scanBtn = findViewById(R.id.scan_btn);
        requestImage = findViewById(R.id.request_image);
        resultImage = findViewById(R.id.result_image);
        statusText = findViewById(R.id.status_text);
        qrText = findViewById(R.id.qr_text);
        progressBar = findViewById(R.id.progress);

        scanBtn.setOnClickListener(this);
        requestImage.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        token = extras.getString("token");

        setProfile(token, extras.getString("userEmail"),"90%");

    }

    private void setProfile(String name,String email,String percent){
        personText.setText(name);
        emailText.setText(email);
        percentText.setText(percent);
    }
    private void refresh() {
        Toast.makeText(getApplicationContext(),"Refresh Clicked",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.scan_btn){
            Intent intent = new Intent(MainActivity.this, ScanCodeActivity.class);
            startActivityForResult(intent,101);
        }
        if(view.getId() == R.id.request_image){
            progressBar.setVisibility(View.VISIBLE);
            sendAttendanceRequest();
            statusText.setText("Attendance Successful");
            qrText.setText("");
            resultImage.setVisibility(View.VISIBLE);
            requestImage.setVisibility(View.GONE);
        }
    }

    private void sendAttendanceRequest() {
       // Toast.makeText(this, scanResult ,Toast.LENGTH_LONG).show();
        progressBar.setVisibility(View.GONE);

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(scanResult)
                        .header("Authorization","Token "+token)
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful()) {
                            MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"Request Successfull",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.refresh){
            refresh();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 101) {
            if(resultCode == Activity.RESULT_OK){
                scanResult = data.getStringExtra("result");
                qrText.setText(scanResult);
                if(scanResult.length()<15) {
                    statusText.setText("Please Scan Properly");
                    resultImage.setVisibility(View.GONE);
                    requestImage.setVisibility(View.GONE);
                }
                else{
                    statusText.setText("Click Here for Attendance");
                    resultImage.setVisibility(View.GONE);
                    requestImage.setVisibility(View.VISIBLE);
                }
            }
            else if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}

