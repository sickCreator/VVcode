package com.example.vcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Code3 extends AppCompatActivity {

    PDFView pdf3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code3);
        pdf3=findViewById(R.id.pdfView3);
        pdf3.fromAsset("fibonacciRecursion.pdf").load();
    }
}