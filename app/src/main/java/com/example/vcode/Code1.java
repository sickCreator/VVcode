package com.example.vcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Code1 extends AppCompatActivity {
    PDFView pdf1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code1);
        pdf1=findViewById(R.id.pdfView);
        pdf1.fromAsset("hello.pdf").load();
    }
}