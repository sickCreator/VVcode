package com.example.vcode;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Code9 extends AppCompatActivity {

    PDFView pdf2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code9);
        pdf2=findViewById(R.id.pdfView9);
        pdf2.fromAsset("sumOfNo.pdf").load();
    }
}