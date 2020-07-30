package com.kepco.informationboard;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class FloorPlanActivity extends AppCompatActivity {
    public static final String SAMPLE_FILE = "Java Code Conventions.pdf";
    private static final String TAG = FloorPlanActivity.class.getSimpleName();
    PDFView pdfView;
    Integer pageNumber = 0;
    String pdfFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_plan);


        pdfView = (PDFView) findViewById(R.id.pdfView);
        pdfView.fromAsset("Java Code Conventions.pdf")
                .load();
    }
}