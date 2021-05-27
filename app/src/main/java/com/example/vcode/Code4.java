package com.example.vcode;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Code4 extends AppCompatActivity {

    PDFView pdf4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code4);
        pdf4=findViewById(R.id.pdfView4);
        pdf4.fromAsset("prime.pdf").load();
    }
}