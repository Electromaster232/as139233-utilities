package me.djelectro.as139233;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class LookingGlass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looking_glass);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://lg.as139233.net");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);

    }

}
