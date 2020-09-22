package com.suptodas.diu.practiceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

public class ProgressbarActivity extends AppCompatActivity {

    ProgressBar progressBar;
    int progressId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);

        progressBar = findViewById(R.id.progressBar);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                doWork();

            }
        });
        thread.start();
    }

    private void doWork() {

        for (progressId = 10; progressId<=100; progressId+=10){

            try {
                Thread.sleep(1000);
                progressBar.setProgress(progressId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}