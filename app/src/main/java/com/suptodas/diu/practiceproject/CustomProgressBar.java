package com.suptodas.diu.practiceproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CustomProgressBar extends AppCompatActivity implements CustomPopUpDialog.DialogListener {


    ProgressBar progressBar;
    TextView textView, userEmailText;
    ConstraintLayout cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_progress_bar);

        progressBar = findViewById(R.id.progressBar2);
        textView = findViewById(R.id.textViewShow);
        cardView = findViewById(R.id.cardView);
        userEmailText = findViewById(R.id.userEmailName);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDialog();

            }
        });
    }

    private void openDialog() {

        CustomPopUpDialog customPopUpDialog = new CustomPopUpDialog();
        customPopUpDialog.show(getSupportFragmentManager(), "login");

    }

    @Override
    public void applyTexts(final String useremail, String userpassword) {

        progressBar.setVisibility(View.VISIBLE);
        textView.setText("Please wait...");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                textView.setText("Done");
                cardView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                PopUpDialog popUpDialog = new PopUpDialog();
                popUpDialog.show(getSupportFragmentManager(), "Dialog");
                userEmailText.setVisibility(View.VISIBLE);
                userEmailText.setText("Welcome "+useremail);
                cardView.setVisibility(View.GONE);
            }
        }, 3000);
    }
}
