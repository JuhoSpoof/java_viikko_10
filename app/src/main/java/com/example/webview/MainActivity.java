package com.example.webview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText sivuInput;
    String nettisivu;
    Button refresh;
    Button mene;
    String edellinen;
    String seuraava;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //nettisivu = "www.google.fi";

        sivuInput = (EditText) findViewById(R.id.sivuInput);
        //sivuInput.setText(nettisivu);


        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);

        //web.loadUrl("http://www.google.fi");
        //web.loadUrl("file:///android_asset/index.html");

        mene = (Button) findViewById(R.id.mene);
        mene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edellinen = nettisivu;
                nettisivu = sivuInput.getText().toString();
                if (nettisivu.equals("index.html")){
                    web.loadUrl("file:///android_asset/index.html");

                }
                else{
                    web.loadUrl("http://"+nettisivu);

                }
            }
        });


        refresh = (Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.loadUrl("http://"+nettisivu);
            }
        });



    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void shoutout (View v){
        web.evaluateJavascript("javascript:shoutOut()", null);
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void initialize (View v){
        web.evaluateJavascript("javascript:initialize()", null);
    }
    public void edellinen (View v){
        seuraava = nettisivu;
        web.loadUrl("http://"+edellinen);
        nettisivu = edellinen;
    }
    public void seuraava (View v){
        edellinen = nettisivu;
        web.loadUrl("http://"+seuraava);
        nettisivu = seuraava;
    }
}



























