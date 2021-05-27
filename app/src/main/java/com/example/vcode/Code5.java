package com.example.vcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Code5 extends AppCompatActivity {

    PDFView pdf5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code5);
        pdf5=findViewById(R.id.pdfView5);
        pdf5.fromAsset("pallindrome.pdf").load();
    }
}