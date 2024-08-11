package com.example.xnyl;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.d_xnyl.R;

public class MainActivity extends AppCompatActivity {
    DauthApiService api=DauthApi.getClient();
    AuthResponse authResponse=new AuthResponse();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Intent maintoSecond=new Intent(MainActivity.this, HomeActivity.class);
        startActivity(maintoSecond);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://auth.delta.nitt.edu/");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
//qwdsfgwrTHNHRMYUKTILY&client_secret=csadvfbgnrwmywtkulifjrknjvnjrnlrnjvlnfvnflv&grant_type=authorization_code&code=f65dbf63a96650e689ef9f800a63ed67177ebe45&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback%2F
     /*   api.getAuthorization("qwdsfgwrTHNHRMYUKTILY","csadvfbgnrwmywtkulifjrknjvnjrnlrnjvlnfvnflv","authorization_code","f65dbf63a96650e689ef9f800a63ed67177ebe45","https%3A%2F%2Fexample.com%2Fcallback%2F").enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                authResponse=response.body();
                Log.i("res","state:"+authResponse.state);
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                Log.e("failure","api failure");
            }
        });
        */
    }
}